package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(7);

        System.out.println(pick(list));



        System.out.println("Hello world!");
    }

    private static int pick(List<Integer> list){
        int max = 0,tmp = 0,counter = 0;
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            int item = list.getFirst();
            if (list.get(i) - item < 2){
                counter++;
            }else {
                tmp = counter;
                max = Math.max(tmp,max);
                item = list.get(i);
                counter = 0;
            }
        }
        return max;
    }
}