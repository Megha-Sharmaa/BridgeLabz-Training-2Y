package com.gla.Assignment1;
import java.util.*;
public class Areaofcircle {
    public static void main(String[] args){
        System.out.println("enter radius: ");
      Scanner sc= new Scanner(System.in);
      double radius = sc.nextDouble();

          double area = 3.14*radius*radius;
          System.out.println("the area of circle is " +area);
    }
}
