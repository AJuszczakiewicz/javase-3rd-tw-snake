package com.codecool.snake.common;

import com.codecool.snake.model.AbstractGameEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ObservableEntity {
    private List<EntityObserver> observers = new ArrayList<>();

    public void addObserver(EntityObserver observer) {
        if(observer != null) {
            observers.add(observer);
        }
    }

    public void notifyAboutChange(AbstractGameEntity changedEntity) {
        observers.forEach(entityObserver -> entityObserver.updateOnChange(changedEntity));
    }
}
