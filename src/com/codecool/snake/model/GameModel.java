package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableModel;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.*;

public class GameModel extends ObservableModel {
    private List<AbstractGameEntity> gameEntities;
    public GameModel() {
        gameEntities = new ArrayList<>();
    }

    public void initModel() {
        spawnGameObject(GameEntityType.SNAKE);

        for(int i = 0; i < 3; ++i) {
            spawnGameObject(GameEntityType.ENEMY);
            spawnGameObject(GameEntityType.POWERUP);
        }
    }

    public void interpretPressEvent(KeyEvent event) {
        for (AbstractGameEntity gameEntity : gameEntities)
            if (gameEntity.getEntityType().equals(GameEntityType.SNAKE)) {
                ((SnakeEntity) gameEntity).interpretPressEvent(event);
            }
    }

    public void interpretReleaseEvent(KeyEvent event) {
        for (AbstractGameEntity gameEntity : gameEntities)
            if (gameEntity.getEntityType().equals(GameEntityType.SNAKE)) {
                ((SnakeEntity) gameEntity).interpretReleaseEvent(event);
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
                entity = new SnakeEntity(20);
                break;
            case ENEMY:
                entity = new EnemyEntity();
                entity.setSpeed(1);
                break;
            case POWERUP:
                entity = new PowerupEntity();
                entity.setSpeed(0);
                break;
        }

        if(entity != null) {
            Random random = new Random();
            entity.setBounds(new Bounds(random.nextInt(500) + 250, random.nextInt(350) + 175, 20));
            entity.setAngle(random.nextInt(360));

            gameEntities.add(entity);
            notifyAboutSpawn(entity);
        }
    }

    private void removeGameObject(AbstractGameEntity entityToRemove) {
        notifyAboutDestroy(entityToRemove);
    }


    private void moveAll() {
//        System.out.println("==> Update model: <move all entities>");

        for (AbstractGameEntity entity:  gameEntities) {
            entity.movement();
        }
    }

    private void cleanDeathEntities() {
        ListIterator<AbstractGameEntity> entitiesIterator = gameEntities.listIterator();
        while(entitiesIterator.hasNext()){
            AbstractGameEntity entity = entitiesIterator.next();
            if(!entity.isAlive()){
                entitiesIterator.remove();
                removeGameObject(entity);
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
                if(!snake.isCollideWith(entity)) continue;

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
