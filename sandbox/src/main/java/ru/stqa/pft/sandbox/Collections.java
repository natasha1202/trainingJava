package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
       /* String [] langs = new String[4]; // array
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "PHP"; */
        String [] langs = {"Java", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList(langs); //new ArrayList<String>();
      //  languages.add("Java");
      //  languages.add("C#");
      //  languages.add("Python");

        /*for (int i =0; i < langs.length; i++){
            System.out.println("I want to know " + langs[i]);
        } */

        for (String l : langs){
            System.out.println("I want to know " + l);
        }

        for (String l : languages){
            System.out.println("I want to know " + l);
        }

       /* for (int i = 0; i < languages.size(); i++){
            System.out.println("I want to know " + languages.get(i));
        } */

        List programmingLanguages = Arrays.asList("Java", "C#", "Python", "Perl", "Scala");

        for (Object l : programmingLanguages){
            System.out.println("I want to know " + l);
        }
    }
}
