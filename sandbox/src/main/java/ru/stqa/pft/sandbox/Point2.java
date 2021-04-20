package ru.stqa.pft.sandbox;

public class Point2 {
    double x;
    double y;

    public Point2 (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point2 p3){
        double d = Math.sqrt(Math.pow((p3.x - this.x), 2) + Math.pow((p3.y - this.y),2));
        return d;
    }
}
