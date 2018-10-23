package com.codecool.snake.controller;


public class FrameControlLoop implements Runnable {
    private Controller controller;

    private boolean isRunning = false;
    private long counter = 0;
    private int tics = 0; //For FPS Debugging
    private long initialTime = System.currentTimeMillis();
    private long startTime = System.currentTimeMillis();
    private boolean iddle = false;


    public FrameControlLoop(Controller controller) {
        this.controller = controller;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isStopped() {
        return !isRunning;
    }

    public void makeIdle() {
        //TODO
        iddle = !iddle;
    }

    public void stop() {
        isRunning = false;
    }



    public void run() {
        isRunning = true;
        while (isRunning){
            long timeFrame = 33; //time in miliseconds for one loop
            long currentTime = System.currentTimeMillis();
            counter += (currentTime - initialTime);
            initialTime = currentTime;

            if (counter >= timeFrame) {
                if (!iddle){
                    controller.updateModel();
                    tics += 1;
                    counter = 0;
                }
            }
            if (currentTime-startTime>1000){
                System.out.println("FPS: "+tics);
                startTime = System.currentTimeMillis();
                tics = 0;
            }

        }

    }
}
