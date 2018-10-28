package com.codecool.snake.view;

import com.codecool.snake.model.common.EntityObserver;
import com.codecool.snake.model.Entity;
import com.codecool.snake.model.Bounds;
import com.codecool.snake.model.SnakeEntity;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Iterator;

public class SnakeView extends Group implements EntityObserver {
    private int INITIAL_ROTATE = 90;

    private ImageView head;
    private Image tail;

    SnakeView(Image costumeForHead, Image costumeForTail){
        this.head = new ImageView(costumeForHead);
        this.tail = costumeForTail;

        getChildren().add(this.head);
//        getChildren().get(0).toFront();
    }

    private void setPartBounds(Node part, Bounds bound) {
        part.setLayoutX(bound.getX());
        part.setLayoutY(bound.getY());
    }


    private void updateSnakeView(Entity changedEntity) {
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

        this.head.setRotate(INITIAL_ROTATE + changedEntity.getAngle());
        //this.head.toFront();
    }

    @Override
    public void updateOnChange(Entity changedEntity) {
        Platform.runLater(() -> updateSnakeView(changedEntity));
    }
}
