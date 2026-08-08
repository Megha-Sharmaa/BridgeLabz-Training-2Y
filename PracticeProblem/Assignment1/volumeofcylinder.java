package com.gla.Assignment1;

import java.util.Scanner;

public class volumeofcylinder {
    public static void main(String[] args){
        System.out.println("enter radius : ");
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();
        System.out.println("enter height : ");
        double height = sc.nextDouble();
        Double Volume =3.14* radius*radius * height;
        System.out.println("the volume of cylinder is :" +Volume);
    }
}
