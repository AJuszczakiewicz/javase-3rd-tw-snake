package com.codecool.snake.model;

import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.List;

public class SnakeEntity extends AbstractGameEntity {
    private HashMap<KeyEvent, Direction> control;
    private List<Bounds> tail;
    private Direction turnDirection;

    public SnakeEntity(int initialSize) {
        //TODO
    }

    public void setControl(HashMap<KeyEvent, Direction> control) {
        //TODO
    }

    public boolean isCollideWith(AbstractGameEntity collider) {
        return collider.getBounds().intersectWith(this.getBounds());
    }

    public void interactWith(AbstractGameEntity otherGameObject) {
        //TODO
    }

    public void interpretEvent(KeyEvent event) {
        //TODO
    }

    public void eat(AbstractGameEntity edibleEntity) {
        //TODO
    }

    public void kill(AbstractGameEntity killableEntity) {
        //TODO
    }

    public void movement() {
        //TODO
    }

    public void death() {
        //TODO
    }



}
