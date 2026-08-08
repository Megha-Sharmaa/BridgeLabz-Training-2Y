package com.gla.Assignment1;
import java.util.*;
public class Calculatesimpleintrest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter pricipal : ");
        Double p=sc.nextDouble();
        System.out.print("enter rate : ");
        Double r=sc.nextDouble();
        System.out.print("enter time : ");
        Double t=sc.nextDouble();
        Double s= p*r*t/100;
        System.out.println("the simple intrest is :"+s);

    }
}
