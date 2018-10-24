package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.model.AbstractGameEntity;
import com.codecool.snake.model.Bounds;
import com.codecool.snake.model.SnakeEntity;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Optional;

public class SnakeView extends Group implements EntityObserver {

    private Image head;
    private Image tail;

    private ImageView addTailPart(){
        ImageView part = new ImageView(tail);
        getChildren().add(part);

        return part;
    }

    SnakeView(Image costumForHead, Image costumForTail){
        this.head = costumForHead;
        this.tail = costumForTail;

        getChildren().add(new ImageView(head));
        getChildren().add(new ImageView(tail));
    }


    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        Iterator<Bounds> snakeBounds = ((SnakeEntity) changedEntity).getSnakeBounds().iterator();
        Iterator<Node> snakeViewParts = getChildren().iterator();

        snakeBounds.forEachRemaining(bound -> {
            Node snakePart;

            if(snakeViewParts.hasNext()) {
                snakePart = snakeViewParts.next();
            }
            else {
                snakePart = addTailPart();
            }

            snakePart.setLayoutX(bound.getX());
            snakePart.setLayoutY(bound.getY());
        });

        getChildren().get(0)
                .setRotate(changedEntity.getAngle());
    }
}
