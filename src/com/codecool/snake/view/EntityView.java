package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityView extends ImageView implements EntityObserver {

    private Image head;

    public EntityView(Image costumForHead){
        this.head = costumForHead;
    }

    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        //TODO
    }
}
