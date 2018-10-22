package com.codecool.snake.controller;


public abstract class FrameControlLoop implements Runnable {
    private boolean readyForNextFrame;

    public void makeIdle() {
        //TODO
    }

    public void stop() {
        //TODO
    }

    public void run() {
        //TODO

    }

    public boolean isRunning() {
        //TODO
        return false;
    }

    public boolean isStopped() {
        //TODO
        return false;
    }

    public boolean isReadyForNextFrame() {
        return readyForNextFrame;
    }
}
