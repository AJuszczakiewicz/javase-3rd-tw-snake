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

    boolean running = false;
    private void updateProcedure(){

        while (true){
            running = true;
            long currentTime = System.currentTimeMillis();
            if(currentTime-startTime>20){
                System.out.println("update Loop");
                startTime = System.currentTimeMillis();
                iterations += 1;
            }
            if (iterations>100){
                running = false;
                System.out.println("Loop break");
                iterations = 0;
                break;
            }

        }
    }



    long startTime = System.currentTimeMillis();
    int iterations = 0;
    public void update(){
        System.out.println("Update Signal");
//        if (!running) {
//            updateProcedure();
//        }
    }


}
