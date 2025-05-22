package org.example.hashtables;

public class HashMain {
    public static void main(String[] args) {
        MyHashtable<String,String> myHashtable = new MyHashtable<>();
        myHashtable.put("Anvar", "2001");
        myHashtable.put("Abror", "2008");
        myHashtable.put("NurMuhammad", "1996");

        System.out.println(myHashtable.get("Abror"));
    }
}
