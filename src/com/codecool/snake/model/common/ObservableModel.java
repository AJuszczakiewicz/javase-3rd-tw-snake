package com.codecool.snake.model.common;

import com.codecool.snake.model.Entity;

import java.util.ArrayList;
import java.util.List;

public class ObservableModel {
    private List<ModelObserver> observators = new ArrayList<>();

    public void addObserver(ModelObserver observer) {
        if (observer != null) {
            observators.add(observer);
        }
    }

    protected void notifyAboutSpawn(Entity spawnedEntity) {
        observators.forEach(modelObserver -> modelObserver.updateOnSpawn(spawnedEntity));
    }

    protected void notifyAboutDestroy(Entity destroyedEntity) {
        observators.forEach(modelObserver -> modelObserver.updateOnDestroy(destroyedEntity));
    }
}
