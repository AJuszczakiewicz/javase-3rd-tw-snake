package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.List;

public class SnakeEntity extends AbstractGameEntity {
    private HashMap<KeyEvent, Direction> control;
    private List<Bounds> tail;
    private Direction turnDirection;

    public SnakeEntity(int initialSize) {
        super();
        this.setEntityType(GameEntityType.SNAKE);


    }

    public void setControl(HashMap<KeyEvent, Direction> control) {
        this.control = control;
    }

    public boolean isCollideWith(AbstractGameEntity collider) {
        return collider.getBounds().intersectWith(this.getBounds());
    }

    public void interactWith(AbstractGameEntity otherGameObject) {

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


}
