package com.gla.String.Level1;
import java.util.Scanner;
public class NumberFormatDemo {
    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println(number);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String text = sc.next();

        try {
            generateException(text);
        } catch (RuntimeException e) {
            System.out.println("Exception generated");
        }

        handleException(text);

        sc.close();
    }
}
