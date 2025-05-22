package org.example.stringbuilder;

public class Main {
    public static void main(String[] args) {

        MyStringBuilder builder = new MyStringBuilder();

        builder.append("bob");
        builder.append("bob");
        builder.append("Anwar");
        System.out.println(builder.reverse("Anwar"));

    }
}
