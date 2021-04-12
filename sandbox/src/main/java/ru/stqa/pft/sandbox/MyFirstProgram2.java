package ru.stqa.pft.sandbox;

public class MyFirstProgram2 {

    public static void main(String[] args) {
        Square s = new Square();
        s.l = 5;
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s) );
        Rectangle r = new Rectangle();
        r.a =4;
        r.b = 6;
        System.out.println("Площадь прямоугольника со сторонами  " + r.a + " и " + r.b  + " = " + area(r) );
        Square2 s2 = new Square2(5);
        System.out.println("Площадь квадрата со стороной " + s2.l + " = " + area(s2));
        Rectangle2 r2 = new Rectangle2(3,5);
        System.out.println("Площадь прямоугольника со сторонами  " + r2.a + " и " + r2.b  + " = " + area(r2) );

    }

        public static double area(Square s){
            return s.l*s.l;
        }
        public static double area(Rectangle r){
            return r.a*r.b;
        }
        public static double area(Square2 s2){
        return s2.l*s2.l;
    }

        public static double area(Rectangle2 r2){
        return r2.a*r2.b;
    }

}
