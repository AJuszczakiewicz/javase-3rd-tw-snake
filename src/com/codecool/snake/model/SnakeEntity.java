package com.codecool.snake.model;

import com.codecool.snake.model.common.GameEntityType;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;

import static com.codecool.snake.common.Config.ROTATE_SPEED;

public class SnakeEntity extends Entity {
    private Deque<Bounds> tail = new ArrayDeque<>();
    private Direction turnDirection = Direction.CENTER;

    SnakeEntity(int initialSize) {
        super();
        this.setEntityType(GameEntityType.SNAKE);

        for(int i = initialSize; i > 0; --i) {
            Bounds newPart = getBounds().cloneEntity();
            tail.addLast(newPart);
        }
    }

    public void movement() {

        switch(turnDirection) {
            case LEFT:
                rotate(-ROTATE_SPEED);
                break;
            case RIGHT:
                rotate(ROTATE_SPEED);
                break;
            default:
                break;
        }

        tail.add(getBounds().cloneEntity());
        tail.poll();
        super.movement();
    }

    boolean isCollideWith(Entity collider) {
        return collider.getBounds().intersectWith(this.getBounds());
    }

    void interactWith(Entity otherGameObject) {

        switch (otherGameObject.getEntityType()) {
            case POWERUP:
                eat(otherGameObject);
                break;
            case ENEMY:
                kill(otherGameObject);
                break;
        }
    }

    private void eat(Entity edibleEntity) {
        System.out.println("==> Snake eat [" + edibleEntity.getEntityType() + "]");

        edibleEntity.death();
    }

    private void kill(Entity killableEntity) {
        System.out.println("==> Snake kill [" + killableEntity.getEntityType() + "]");

        killableEntity.death();
    }

    public ArrayList<Bounds> getSnakeBounds(){
        ArrayList<Bounds> snakeBounds = new ArrayList<>();
        snakeBounds.add(getBounds());
        snakeBounds.addAll(tail);

        return snakeBounds;
    }

    void interpretPressEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.LEFT) {
            this.turnDirection = Direction.LEFT;
        }

        if (event.getCode() == KeyCode.RIGHT) {
            this.turnDirection = (Direction.RIGHT);
        }
    }

    void interpretReleaseEvent() {
        this.turnDirection = Direction.CENTER;
    }

}
