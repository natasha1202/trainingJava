package ru.stqa.pft.sandbox;

public class Point2 {
    double x;
    double y;

    public Point2 (double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double distance(Point2 p3, Point2 p4){
        double d = Math.sqrt(Math.pow((p3.x - p4.x), 2) + Math.pow((p3.y - p4.y),2));
        return d;
    }
}
