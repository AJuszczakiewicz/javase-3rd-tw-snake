package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableEntity;

public class AbstractGameEntity extends ObservableEntity {
    private GameEntityType entityType;
    private boolean alive;
    private Bounds bound;
    private int angle;

    public AbstractGameEntity() {
        this.alive = true;
        this.bound = new Bounds(0, 0, 0);
        this.angle = 0;
    }

    public AbstractGameEntity(Bounds bound){
        this.alive = true;
        this.bound = bound;
        this.angle = 0;
    }

    Bounds getBounds() {
        return this.bound;
    }

    void setBounds(Bounds newBounds) {
        this.bound = newBounds;
    }

    public int getAngle() {
        return this.angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public boolean isAlive() {
        return alive;
    }

    public void rotate(int rotateBy) {
        this.angle += rotateBy;
    }

    public void movement() {
        this.bound.moveTo(10, this.angle);
    }

    public void death() {
        System.out.println("==> ... Death of " + entityType);

        this.alive = false;
    }

    public void setEntityType(GameEntityType entityType) {
        this.entityType = entityType;
    }

    public GameEntityType getEntityType() {
        return entityType;
    }


}
