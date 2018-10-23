package com.codecool.snake.controller;

import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;

import java.awt.event.KeyEvent;

public class Controller {
    private GameView view;
    private GameModel model;

    public Controller(GameModel model, GameView view){
        this.view = view;
        this.model = model;
    }

    public void handleOnKeyPressed(KeyEvent event){
        //TODO
    }

    public void handleOnKeyReleased(KeyEvent event){
        //TODO
    }

    void updateModel(){
        model.update();
    }
}
