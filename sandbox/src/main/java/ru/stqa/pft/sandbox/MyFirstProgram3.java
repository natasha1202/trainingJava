package ru.stqa.pft.sandbox;

public class MyFirstProgram3 {

    public static void main(String[] args) {
        Square3 s = new Square3(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle3 r = new Rectangle3(4, 6);
        System.out.println("Площадь прямоугольника со сторонами  " + r.a + " и " + r.b + " = " + r.area());
    }


}
