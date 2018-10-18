package com.codecool.snake.model;

import java.util.List;

public class GameLoop {
    private int frameDuration;
    private GameModel worldOfGame;
    private GameLoopState loopState;
    private double startTime;

    public GameLoop(GameModel worldOfGame) {
        //TODO
    }

    private List<AbstractGameEntity> whichEntitiesCollide() {
        //TODO
        return null;
    }

    private void moveAll() {
        //TODO
    }

    private void cleanDeathEntities() {
        //TODO
    }

    private double captureStartTime() {
        //TODO
        return 0;
    }

    private double captureCurrentTime() {
        //TODO
        return 0;
    }

    public boolean isRunning() {
        //TODO
        return false;
    }

    public boolean isStopped() {
        //TODO
        return false;
    }

    public void makeIdle() {
        //TODO
    }

    public void stop() {
        //TODO
    }

    public void run() {
        //TODO
    }
}
