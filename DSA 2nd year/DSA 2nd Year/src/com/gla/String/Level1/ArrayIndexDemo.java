package com.gla.String.Level1;
import java.util.Scanner;
public class ArrayIndexDemo {
    public static void generateException(String[] names) {
        System.out.println(names[names.length + 1]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length + 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];

        System.out.println("Enter 3 names:");

        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }

        try {
            generateException(names);
        } catch (RuntimeException e) {
            System.out.println("Exception generated");
        }

        handleException(names);

        sc.close();
    }
}
