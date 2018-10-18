package com.codecool.snake.model;

public class Bounds {
    private int x;
    private int y;
    private int radius;

    public Bounds(int x, int y, int radius){
        //TODO
    }

    public Bounds(Bounds boundsToCopy){
        //TODO
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public boolean intersectWith(Bounds otherBounds){
        //TODO
        return false;
    }

    public void moveTo(int distance, int angle){
        //TODO
    }
}
