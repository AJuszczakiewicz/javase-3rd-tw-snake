package com.codecool.snake.controller;

import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;
import javafx.scene.input.KeyEvent;

public class GameController {
    private GameView view;
    private GameModel model;

    public GameController(GameModel model, GameView view){
        this.view = view;
        this.model = model;
        view.attachInputToController(this);
    }

    public void handleOnKeyPressed(KeyEvent event){
        model.interpretPressEvent(event);
    }
    public void handleOnKeyReleased(KeyEvent event){
        model.interpretReleaseEvent();
    }

    void updateModel(){
        model.updateModel();
    }
}
