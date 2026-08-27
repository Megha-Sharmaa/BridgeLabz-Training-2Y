package com.gla.Array.Level1;
import java.util.Scanner;
public class CheckEven {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.print("Enter the 5 elements");
        for(int i = 0; i<arr.length; i++){
          arr[i] = sc.nextInt();
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > 0) {
                if (arr[i] % 2 == 0) {
                    System.out.println(arr[i] + " Positive and Even");
                } else {
                    System.out.println(arr[i] + " is Posutuve and Odd");
                }
            }else if(arr[i] <0){
                    System.out.println(arr[i] + " is Negative");
                }else{
                    System.out.println(arr[i] + " is Zero");
                }
            }
            if (arr[0] == arr[4]) {
                System.out.println("First and last elements are Equal");
            } else if (arr[0] > arr[4]) {
                System.out.println("First element is Greater than last element");
            } else {
                System.out.println("First element is Less than last element");
            }

            sc.close();
        }
    }

