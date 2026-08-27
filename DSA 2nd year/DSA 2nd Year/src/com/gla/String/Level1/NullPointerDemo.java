package com.gla.String.Level1;

public class NullPointerDemo {
    public static void generateException() {

        String text = null;


        System.out.println(text.length());
    }

    public static void main(String[] args) {

        generateException();

    }
}
