package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityView extends Group implements EntityObserver {

    private Image head;

    public EntityView(Image costumForHead){
        this.head = costumForHead;

        getChildren().add(new ImageView(head));
    }

    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        setLayoutX(changedEntity.getBounds().getX());
        setLayoutY(changedEntity.getBounds().getY());
        setRotate(changedEntity.getAngle());
    }
}
