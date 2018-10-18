package com.codecool.snake.model;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ObservableModel;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class GameModel extends ObservableModel {
    private List<AbstractGameEntity> gameEntities;
    private GameLoop gameLoop;
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




}
