package com.gla.Assignment1;
import java.util.*;
public class perimeterofrectangle {
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter length of rectangle :");
       int l=sc.nextInt();
       System.out.println("Enter width of rectangle :");
       int b=sc.nextInt();
       int p=2*(l+b);
       System.out.println("the perimeter of rectangle is: " +p);

    }
}
