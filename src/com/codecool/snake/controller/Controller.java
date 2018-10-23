package com.codecool.snake.controller;

import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;

import java.awt.event.KeyEvent;

public class Controller {
    private GameView view;
    private GameModel model;

    Controller(){
        //TODO
        this.view = new GameView();
        this.model = new GameModel();
    }

    public void handleOnKeyPressed(KeyEvent event){
        //TODO
    }

    public void handleOnKeyReleased(KeyEvent event){
        //TODO
    }

    void updateModel(){
        model.update();
        //TODO
    }
}
