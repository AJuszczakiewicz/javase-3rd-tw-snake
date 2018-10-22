package com.codecool.snake.controller;


public class FrameControlLoop implements Runnable {
    private boolean readyForNextFrame;
    private boolean isRunning = false;
    private double deltaT = 0;
    private long initialTime = System.currentTimeMillis();
    private long timeFrame = 33; //time in miliseconds for one loop
    private boolean iddle = false;


    public void makeIdle() {
        iddle = !iddle;
    }

    public void stop() {
        isRunning = false;
    }

    public void run() {
        isRunning = true;
        while (isRunning){
            long currentTime = System.currentTimeMillis();
            deltaT += (currentTime - initialTime) / timeFrame;
            initialTime = currentTime;

            if (deltaT >= 1) {
                if (!iddle){
                    readyForNextFrame = true;
                }

            }
        }

    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isStopped() {
        return !isRunning;
    }

    public boolean isReadyForNextFrame() {
        return readyForNextFrame;
    }
}
