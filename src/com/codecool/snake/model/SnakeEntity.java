package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import javafx.scene.input.KeyEvent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class SnakeEntity extends AbstractGameEntity {
    private HashMap<KeyEvent, Direction> control;
    private Deque<Bounds> tail = new ArrayDeque<>();
    private Direction turnDirection = Direction.CENTER;

    public SnakeEntity(int initialSize) {
        super();
        this.setEntityType(GameEntityType.SNAKE);

        for(int i = 1; i <= initialSize; ++i) {
            Bounds newPart = new Bounds(getBounds());
            newPart.moveTo(30*i, 0);

            tail.addLast(newPart);
        }
    }

    public void setControl(HashMap<KeyEvent, Direction> control) {
        this.control = control;
    }

    public boolean isCollideWith(AbstractGameEntity collider) {
        return collider.getBounds().intersectWith(this.getBounds());
    }

    public void interactWith(AbstractGameEntity otherGameObject) {
        System.out.println("==> Snake interact with [" + otherGameObject.getEntityType() + "]");

        switch (otherGameObject.getEntityType()) {
            case POWERUP:
                eat(otherGameObject);
                break;
            case ENEMY:
                kill(otherGameObject);
                break;
        }
    }

    public void interpretEvent(KeyEvent event) {
        //TODO
    }

    public void eat(AbstractGameEntity edibleEntity) {
        System.out.println("==> Snake eat [" + edibleEntity.getEntityType() + "]");

        edibleEntity.death();
    }

    public void kill(AbstractGameEntity killableEntity) {
        System.out.println("==> Snake kill [" + killableEntity.getEntityType() + "]");


        killableEntity.death();
    }

    public void movement() {
        switch(turnDirection) {
            case LEFT:
                rotate(-25);
            case RIGHT:
                rotate(25);
        }

        tail.pollLast();
        tail.addFirst(getBounds());
        super.movement();
    }


}
