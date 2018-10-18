package com.codecool.snake.view;

import com.codecool.snake.common.GameEntityType;
import com.codecool.snake.common.ModelObserver;
import com.codecool.snake.controller.Controller;
import com.codecool.snake.model.AbstractGameEntity;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;

public class GameView implements ModelObserver {
    private HashMap<GameEntityType, Image> costumes;
    private Scene scene;

    public GameView(){
        //TODO
    }


    @Override
    public void updateOnSpawn(AbstractGameEntity spawnEntity) {
        //TODO
    }

    @Override
    public void updateOnDestroy(AbstractGameEntity destroyedEntity) {
        //TODO
    }

    public void attachViewToStage(Stage stage){
        //TODO
    }

    public void attachInputToController(Controller controller){
        //TODO
    }

    private static void loadCostumes(){
        //TODO
    }
}
