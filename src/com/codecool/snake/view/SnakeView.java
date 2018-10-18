package com.codecool.snake.view;

import com.codecool.snake.common.EntityObserver;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SnakeView extends ImageView implements EntityObserver {

    private Image head;
    private Image tail;

    public SnakeView(Image costumForHead, Image costumForTail){
        //TODO
    }

    @Override
    public void updateOnChange(AbstractGameEntity changedEntity) {
        //TODO
    }
}
