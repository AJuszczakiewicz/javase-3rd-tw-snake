package com.codecool.snake.view;

import com.codecool.snake.model.common.EntityObserver;
import com.codecool.snake.model.Entity;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityView extends Group implements EntityObserver {

    EntityView(Image costumeForHead){
        getChildren().add(new ImageView(costumeForHead));
    }

    private void updateEntity(Entity changedEntity) {
        setLayoutX(changedEntity.getBounds().getX());
        setLayoutY(changedEntity.getBounds().getY());
        setRotate(changedEntity.getAngle());
    }

    @Override
    public void updateOnChange(Entity changedEntity) {
        Platform.runLater(() -> updateEntity(changedEntity)); //Resolves problem with foreign thread making changes in JavaFX
    }
}
