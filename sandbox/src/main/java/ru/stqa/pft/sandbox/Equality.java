package ru.stqa.pft.sandbox;

public class Equality {

    public static void main(String[] args) {
        String s1 = "firefox";
        String s2 = s1;
        String s3 = new String(s1);
        String s4 = "firefox";
        String s5 = "fire"+"fox";
        String s6 = "firefox 2.0";
        String s7 = "firefox "+Math.sqrt(4.0);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s4));
        System.out.println(s1 == s5);
        System.out.println(s1.equals(s5));
        System.out.println(s6 == s7);
        System.out.println(s6.equals(s7));
    }
}
