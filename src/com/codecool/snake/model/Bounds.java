package com.codecool.snake.model;

import sun.font.TrueTypeFont;

public class Bounds {
    private double x;
    private double y;
    private int radius;

    public Bounds(double x, double y, int radius){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Bounds(Bounds boundsToCopy){
        this.radius = boundsToCopy.getRadius();
        this.x = boundsToCopy.getX();
        this.y = boundsToCopy.getY();
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
        if (Math.sqrt( Math.pow(this.x - otherBounds.getY(), 2) + Math.pow(this.y - otherBounds.getY(), 2)) <= this.radius + otherBounds.getRadius())
            return true;
        return false;
    }

    public void moveTo(int distance, int angle){
        this.x += distance*Math.cos(angle);
        this.y += distance*Math.sin(angle);
    }
}
