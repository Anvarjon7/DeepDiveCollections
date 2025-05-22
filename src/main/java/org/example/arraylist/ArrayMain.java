package org.example.arraylist;

public class ArrayMain {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Anwar");
        list.add("Ira");
        list.add("Anna");
        list.add("Bob");

        list.remove(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.size());
    }

}
