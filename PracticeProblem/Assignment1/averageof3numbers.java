package com.gla.Assignment1;
import java.util.Scanner;

public class averageof3numbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number 1:");
        int n1=sc.nextInt();
        System.out.println("enter number 2:");
        int n2=sc.nextInt();
        System.out.println("enter number 3:");
        int n3=sc.nextInt();
        int sum=0;
        sum=n1+n2+n3;
        int total=sum/3;
        System.out.println("the average of 3 numbers is : " +total);
    }
}
