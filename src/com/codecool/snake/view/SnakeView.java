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

public class SnakeView extends Group implements EntityObserver {

    private Image head;
    private Image tail;

    public SnakeView(Image costumForHead, Image costumForTail){
        this.head = costumForHead;
        this.tail = costumForTail;

        getChildren().add(new ImageView(head));
        getChildren().add(new ImageView(tail));
    }

    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        ListIterator<Node> viewElements = getChildren().listIterator();
        Iterator<Bounds> snakeTailParts = ((SnakeEntity) changedEntity).getSnakeBounds().iterator();

        while(viewElements.hasNext() && snakeTailParts.hasNext()) {
            Bounds part = snakeTailParts.next();
            ImageView partOfSnake = (ImageView) viewElements.next();

            partOfSnake.setX(part.getX());
            partOfSnake.setY(part.getY());
        }

        snakeTailParts.forEachRemaining(bounds -> {
            ImageView newPart = new ImageView(tail);

            newPart.setX(bounds.getX());
            newPart.setY(bounds.getY());

            getChildren().add(newPart);
        });

        if(!getChildren().isEmpty()) {
            ImageView partOfSnake = (ImageView) getChildren().get(0);
            partOfSnake.setRotate(changedEntity.getAngle());
        }


//        setX(changedEntity.getBounds().getX());
//        setY(changedEntity.getBounds().getY());
//        setRotate(changedEntity.getAngle());
    }
}
