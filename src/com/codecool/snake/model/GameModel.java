package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableModel;
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

    void interpretEvent(KeyEvent event) {
        //TODO
    }

    List<AbstractGameEntity> getAllGameEntities() {
        //TODO
        return null;
    }

    void spawnGameObject(GameEntityType type) {
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
        }
    }

    private void cleanDeathEntities() {
//        System.out.println("==> Update model: <cleanup>");

        Iterator<AbstractGameEntity> entity = gameEntities.iterator();

        while(entity.hasNext()) {
            if(!entity.next().isAlive()) {
                entity.remove();
            }
        }
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
