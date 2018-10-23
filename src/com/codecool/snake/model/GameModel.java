package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableModel;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class GameModel extends ObservableModel {
    private List<AbstractGameEntity> gameEntities;
    void GameModel() {
        //TODO
    }

    void initModel() {
        //TODO
    }

    void interpretEvent(KeyEvent event) {
        //TODO
    }

    List<AbstractGameEntity> getAllGameEntities() {
        //TODO
        return null;
    }

    void spawnGameObject(GameEntityType type) {
        //TODO
    }

    void removeGameObject(AbstractGameEntity entityToRemove) {
        //TODO
    }

    private void moveAll() {
        //TODO
    }

    private void cleanDeathEntities() {
        //TODO
    }

    private void checkForCollision() {
        //TODO
    }

    long startTime = System.currentTimeMillis();
    int iterations = 0;
    public void update(){
        cleanDeathEntities();
        checkForCollision();
        moveAll();
    }


}
