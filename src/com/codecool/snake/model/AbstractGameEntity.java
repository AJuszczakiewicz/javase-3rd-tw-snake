package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;

public class AbstractGameEntity {
    private GameEntityType entityType;
    private boolean alive;
    private Bounds bound;
    private int angle;

    public AbstractGameEntity() {
        //TODO
    }

    public AbstractGameEntity(Bounds bound){
        //TODO
    }

    Bounds getBounds() {
        //TODO
        return null;
    }

    void setBounds(Bounds newBounds) {
        //TODO
    }

    public int getAngle() {
        //TODO
        return 0;
    }

    public void setAngle(int angle) {
        //TODO
    }

    public boolean isAlive() {
        //TODO

        return false;
    }

    public void rotate(int rotateBy) {
        //TODO
    }

    public void movement() {
        //TODO
    }

    public void death() {
        //TODO
    }


}
