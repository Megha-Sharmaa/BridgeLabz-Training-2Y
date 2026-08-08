package com.gla.Assignment1;
import java.util.*;
public class AddTwoNmbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        int a=sc.nextInt();
        System.out.println("Enter second number:");
        int b= sc.nextInt();

        int sum=0;
        sum=a+b;
        System.out.println("the sum of two numbers is : " +sum);
    }
}
