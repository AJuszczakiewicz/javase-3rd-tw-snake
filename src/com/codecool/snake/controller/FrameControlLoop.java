package com.codecool.snake.controller;

import static com.codecool.snake.common.Config.FRAMERATE;

public class FrameControlLoop extends Thread implements Runnable {
    private Controller controller;

    private boolean isRunning = false;

    private int tics = 0; //For FPS Debugging
    private long initialTime  = System.currentTimeMillis(),
            currentTime  = System.currentTimeMillis(),
            startTime  = System.currentTimeMillis(),
            timeFrame = 1000/FRAMERATE, //time in milliseconds for one loop;
            counter = 0;

    public FrameControlLoop(Controller controller) {
        this.controller = controller;
    }

    public void run() {

        isRunning = true;
        while (isRunning){
            currentTime = System.currentTimeMillis();
            counter += (currentTime - initialTime);
            initialTime = currentTime;

            if (counter >= timeFrame) {
                controller.updateModel();
                tics += 1;
                counter = 0;
            }

            //if statement for FPS loging in console=========
            if (currentTime-startTime>1000){
                System.out.println("FPS: "+tics);
                startTime = System.currentTimeMillis();
                tics = 0;
            }

            //===============================================
        }
    }
}
