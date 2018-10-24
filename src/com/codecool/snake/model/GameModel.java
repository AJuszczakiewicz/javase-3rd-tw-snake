package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableModel;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModel extends ObservableModel {
    private List<AbstractGameEntity> gameEntities;
    private GameLoop gameLoop;

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




}
