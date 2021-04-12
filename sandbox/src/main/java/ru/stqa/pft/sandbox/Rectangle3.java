package ru.stqa.pft.sandbox;

public class Rectangle3 {
    public double a;
    public double b;

    public Rectangle3(double a, double b){
        this.a=a;
        this.b=b;
    }

    public double area() {
        return this.a * this.b;
    }
}
