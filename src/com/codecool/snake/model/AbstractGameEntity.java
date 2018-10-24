package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableEntity;

public class AbstractGameEntity extends ObservableEntity {
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

    public Bounds getBounds() {
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

    void setGameEntityType(GameEntityType type){
        entityType = type;
    }

    public GameEntityType getGameEntityType(){
        return entityType;
    }
}
