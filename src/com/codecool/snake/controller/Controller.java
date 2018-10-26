package com.codecool.snake.controller;

import com.codecool.snake.model.GameModel;
import com.codecool.snake.view.GameView;
import javafx.scene.input.KeyEvent;

public class Controller {
    private GameView view;
    private GameModel model;

    public Controller(GameModel model, GameView view){
        this.view = view;
        this.model = model;
        view.attachInputToController(this);
    }

    public void handleOnKeyPressed(KeyEvent event){
        model.interpretPressEvent(event);
    }
    public void handleOnKeyReleased(KeyEvent event){
        model.interpretReleaseEvent(event);
    }

    public void changeArenaWidth(int windowWidth) {
        model.setArenaWidth(windowWidth);
    }

    public void changeArenaHeight(int height) {
        model.setArenaHeight(height);
    }

    void updateModel(){
        model.update();
    }
}
