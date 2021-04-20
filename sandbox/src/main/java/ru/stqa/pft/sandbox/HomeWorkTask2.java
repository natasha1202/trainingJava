package ru.stqa.pft.sandbox;

public class HomeWorkTask2 {

    public static void main(String[] args) {
        Point p1 = new Point();
        p1.x = 1;
        p1.y = 2;
        Point p2 = new Point();
        p2.x = 4;
        p2.y = 6;
        System.out.println("Расстояние между точками p1" +
                "(" + p1.x + ", " + p1.y + ")" + " и p2 " + "(" + p2.x + ", " + p2.y + ")" + " = " +
                distance(p1, p2));

        Point2 p3 = new Point2(1, 1);
        Point2 p4 = new Point2(4, 5);
        double d = p3.distance(p4);
        System.out.println("Расстояние между точками p3" +
                "(" + p3.x + ", " + p3.y + ")" + " и p4 " + "(" + p4.x + ", " + p4.y + ")" + " = " +
                d);

    }

    public static double distance(Point p1, Point p2){
        double d = Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y),2));
        return d;
    }
}
