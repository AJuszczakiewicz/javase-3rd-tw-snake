package com.codecool.snake.common;

import com.codecool.snake.model.AbstractGameEntity;

import java.util.List;

public class ObservableModel {
    private List<ModelObserver> observators;

    public void addObserver(ModelObserver observer){
        //TODO
    }

    public void notifyAboutSpawn(AbstractGameEntity spawnedEntity){
        //TODO
    }

    public void notifyAboutDestroy(AbstractGameEntity destroyedEntity){
        //TODO
    }
}
