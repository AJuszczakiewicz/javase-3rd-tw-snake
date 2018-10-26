package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.model.AbstractGameEntity;
import com.codecool.snake.model.Bounds;
import com.codecool.snake.model.SnakeEntity;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class SnakeView extends Group implements EntityObserver {

    private ImageView head;
    private Image tail;

    SnakeView(Image costumForHead, Image costumForTail){
        this.head = new ImageView(costumForHead);
        this.tail = costumForTail;

        getChildren().add(this.head);
        getChildren().get(0).toFront();
    }

    private void setPartBounds(Node part, Bounds bound) {
        part.setLayoutX(bound.getX());
        part.setLayoutY(bound.getY());
    }


    public void updateSnakeView(AbstractGameEntity changedEntity) {
        Iterator<Bounds> snakeBounds = ((SnakeEntity) changedEntity).getSnakeBounds().iterator();


        getChildren().listIterator().forEachRemaining(part -> {
            if(snakeBounds.hasNext()) setPartBounds(part, snakeBounds.next());
        });

        snakeBounds.forEachRemaining(bound -> {
            ImageView part = new ImageView(tail);

            getChildren().add(part);
            setPartBounds(part, bound);
            //part.toFront();
        });

        this.head.setRotate(90 + changedEntity.getAngle());
        //this.head.toFront();

    }

    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        Platform.runLater(() -> updateSnakeView(changedEntity));
    }
}
