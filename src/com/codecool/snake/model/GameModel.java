package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableModel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModel extends ObservableModel {
    private List<AbstractGameEntity> gameEntities;
    public GameModel() {
        gameEntities = new ArrayList<>();
    }

    public void initModel() {
        spawnGameObject(GameEntityType.SNAKE);

        for(int i = 0; i < 5; ++i) {
            spawnGameObject(GameEntityType.ENEMY);
            spawnGameObject(GameEntityType.POWERUP);
        }
    }

    public void interpretPressEvent(KeyEvent event) {
        for (AbstractGameEntity gameEntity : gameEntities)
            if (gameEntity.getEntityType().equals(GameEntityType.SNAKE)) {
                ((SnakeEntity) gameEntity).interpretEvent(event);
            }
    }


    List<AbstractGameEntity> getAllGameEntities() {
        //TODO
        return null;
    }

    private void spawnGameObject(GameEntityType type) {
        AbstractGameEntity entity = null;

        switch (type) {
            case SNAKE:
                entity = new SnakeEntity(5);
                break;
            case ENEMY:
                entity = new EnemyEntity();
                break;
            case POWERUP:
                entity = new PowerupEntity();
                break;
        }

        if(entity != null) {
            gameEntities.add(entity);
            notifyAboutSpawn(entity);
        }
    }

    void removeGameObject(AbstractGameEntity entityToRemove) {
        gameEntities.remove(entityToRemove);
        notifyAboutDestroy(entityToRemove);
    }


    private void moveAll() {
//        System.out.println("==> Update model: <move all entities>");

        for (AbstractGameEntity entity:  gameEntities) {
                entity.movement();
            if(entity.getEntityType().equals(GameEntityType.SNAKE)){
//                System.out.println("Move my Snake");
            }
        }
    }

    private void cleanDeathEntities() {
//        System.out.println("==> Update model: <cleanup>");

        gameEntities.removeIf(abstractGameEntity -> !abstractGameEntity.isAlive());
    }

    private void checkForCollision() {
//        System.out.println("==> Update model: <check collision>");

        // filter list
        ArrayList<AbstractGameEntity> entities = new ArrayList<>();
        ArrayList<SnakeEntity> snakes = new ArrayList<>();

        for(AbstractGameEntity entity : gameEntities) {
            switch (entity.getEntityType()) {
                case SNAKE:
                    snakes.add((SnakeEntity) entity);
                    break;

                default:
                    entities.add(entity);
            }
        }

        for(SnakeEntity snake: snakes) {
            for(AbstractGameEntity entity: entities) {
                if(snake.isCollideWith(entity)) continue;

                snake.interactWith(entity);
            }
        }
    }

    long startTime = System.currentTimeMillis();
    int iterations = 0;
    public void update(){
        cleanDeathEntities();
        checkForCollision();
        moveAll();
    }


}
