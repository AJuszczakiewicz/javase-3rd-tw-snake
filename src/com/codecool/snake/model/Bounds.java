package com.codecool.snake.model;

public class Bounds {
    private double x;
    private double y;
    private int radius;

    Bounds(double x, double y, int radius){
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    private Bounds(Bounds boundsToCopy){
        this.radius = boundsToCopy.getRadius();
        this.x = boundsToCopy.getX();
        this.y = boundsToCopy.getY();
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    private int getRadius() {
        return radius;
    }

    boolean intersectWith(Bounds otherBounds){
        return Math.sqrt(Math.pow(this.x - otherBounds.getX(), 2) + Math.pow(this.y - otherBounds.getY(), 2)) <= this.radius + otherBounds.getRadius();
    }

    void moveTo(int distance, int angle){
        this.x += distance*Math.cos(Math.toRadians(angle));
        this.y += distance*Math.sin(Math.toRadians(angle));
    }

    Bounds cloneEntity() {
        return new Bounds(this);
    }
}