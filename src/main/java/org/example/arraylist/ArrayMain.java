package org.example.arraylist;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ArrayMain {
    public static void main(String[] args) {
//        MyArrayList<String> list = new MyArrayList<>();
//        list.add("Anwar");
//        list.add("Ira");
//        list.add("Anna");
//        list.add("Bob");
//
//        list.remove(1);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(list.size());

        Scanner sc = new Scanner(System.in);
        double payment = sc.nextDouble();
        sc.close();
        NumberFormat nf = NumberFormat.getInstance();
        NumberFormat eng = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat ind = NumberFormat.getCurrencyInstance(Locale.of("eng","INDIA"));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        List<Object> countries = new ArrayList<>();
        countries.add(eng);
        countries.add(ind);
        countries.add(china);
        countries.add(france);


    }

}

abstract class Arithmetic{


    int add(int a, int b){
        return a + b;
    };
}
