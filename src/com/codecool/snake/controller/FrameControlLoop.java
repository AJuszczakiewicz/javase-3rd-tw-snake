package com.codecool.snake.controller;


public class FrameControlLoop implements Runnable {
    private Controller controller;

    private boolean readyForNextFrame;
    private boolean isRunning = false;
    private long timePassed = 0;
    private long initialTime = System.currentTimeMillis();
    private boolean iddle = false;
    private long startTime = System.currentTimeMillis();
    private long timer = System.currentTimeMillis();
    private int tics = 0;

    public FrameControlLoop() {
        controller = new Controller();
    }


    public void makeIdle() {
        iddle = !iddle;
    }

    public void stop() {
        isRunning = false;
    }

    public void run() {
        isRunning = true;
        while (isRunning){
            long timeFrame = 50; //time in miliseconds for one loop
            long currentTime = System.currentTimeMillis();
            timePassed += (currentTime - initialTime);
            initialTime = currentTime;

            if (timePassed >= timeFrame) {
                if (!iddle){
                    controller.updateModel();
//                    readyForNextFrame = true;
                    tics += 1;
                    timePassed = 0;
                }
            }
            if (currentTime-startTime>1000){
                System.out.println("FPS: "+tics);
                startTime = System.currentTimeMillis();
                tics = 0;
            }
            if (currentTime-timer>30000){
                isRunning=!isRunning;
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

    public void consumeFrame(){
        readyForNextFrame = false;
    }
}
