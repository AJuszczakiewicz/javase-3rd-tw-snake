package com.codecool.snake.common;

import com.codecool.snake.model.AbstractGameEntity;

import java.util.List;

public class ObservableEntity {
    private List<EntityObserver> observers;

    public void addObserver(EntityObserver observer) {
        //TODO
    }

    public void notifyAboutChange(AbstractGameEntity changedEntity) {
        //TODO
    }
}
