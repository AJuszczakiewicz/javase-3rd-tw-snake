package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.List;

public class SnakeEntity extends AbstractGameEntity {
    private HashMap<KeyEvent, Direction> control;
    private Direction turnDirection;
    private Deque<Bounds> tail = new ArrayDeque<>();

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
    }

    public void interpretEvent(KeyEvent event) {
        //TODO
    }

    public void eat(AbstractGameEntity edibleEntity) {
        System.out.println("==> Snake eat [" + edibleEntity.getEntityType() + "]");
    }

    public void kill(AbstractGameEntity killableEntity) {
        System.out.println("==> Snake kill [" + killableEntity.getEntityType() + "]");
    }

    public void movement() {
        //TODO
    }


}
