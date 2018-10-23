package com.codecool.snake.common;

import com.codecool.snake.model.AbstractGameEntity;

import java.util.ArrayList;
import java.util.List;

public class ObservableModel {
    private List<ModelObserver> observators = new ArrayList<>();

    public void addObserver(ModelObserver observer){
        if(observer != null) {
            observators.add(observer);
        }
    }

    public void notifyAboutSpawn(AbstractGameEntity spawnedEntity){
        observators.forEach(modelObserver -> modelObserver.updateOnSpawn(spawnedEntity));
    }

    public void notifyAboutDestroy(AbstractGameEntity destroyedEntity){
        observators.forEach(modelObserver -> modelObserver.updateOnDestroy(destroyedEntity));
    }
}
