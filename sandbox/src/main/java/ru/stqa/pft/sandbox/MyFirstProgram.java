package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        System.out.println(2 + 2);
        System.out.println(2 * 2);
        System.out.println(2 / 2);
        System.out.println(2 - 2);

        System.out.println(1 / 2);
        System.out.println(1.0 / 2);
        System.out.println(2.0 / 2);
        System.out.println("2" + "2");
        System.out.println("2" + 2);
        System.out.println(2 + 2 * 2);
        System.out.println((2 + 2) * 2);
        System.out.println("2 + 2 = " + (2 + 2));

        int l2 = 6;
        int s = l2 * l2;
        System.out.println("Площадь квадрата со стороной " + l2 + " = " + s);

        String somebody = "world";

        // Lesson 1.7 Methods

        System.out.println("Hello, " + somebody + " !");
        hello("world");
        hello("user");
        hello("Alexei");
        double l = 5;
        System.out.println("Площадь квадрата со стороной " + l + " = " + area(l) );
        double a =4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами  " + a + " и " + b  + " = " + area(a,b) );

    }


        public static void hello(String somebody2){
            System.out.println("Hello, " + somebody2 + " !");

    }
        public static double area(double l){
        return l*l;
    }
        public static double area(double a, double b){
        return a*b;
    }
}
