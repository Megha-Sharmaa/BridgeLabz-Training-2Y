package com.gla.Assignment1;
import java.util.*;
public class convertkilometerstomiles {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        double kilometers = sc.nextDouble();

        double miles = kilometers * 0.621371;

        System.out.println("Distance in miles = " + miles);

    }
}
