package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityView extends Group implements EntityObserver {

    private Image head;

    EntityView(Image costumForHead){
        this.head = costumForHead;

        getChildren().add(new ImageView(head));
    }

    public void updateEntity(AbstractGameEntity changedEntity) {
        setLayoutX(changedEntity.getBounds().getX());
        setLayoutY(changedEntity.getBounds().getY());
        setRotate(changedEntity.getAngle());
    }

    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        Platform.runLater(() -> updateEntity(changedEntity));
    }
}
