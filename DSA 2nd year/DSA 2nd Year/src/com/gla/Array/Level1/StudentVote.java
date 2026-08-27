package com.gla.Array.Level1;
import java.util.Scanner;
public class StudentVote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        System.out.print("Enter age of 10 Students");
        for (int i = 0; i < ages.length; i++) {
            System.out.println("Enter age for student" + (i + 1) + ":");
            ages[i] = sc.nextInt();
        }
        System.out.println("\n--- Voting Eligibility Results ---");


        for (int i = 0; i < ages.length; i++) {
            int currentAge = ages[i];


            if (currentAge < 0) {
                System.out.println("invalid age");
            } else if (currentAge >= 18) {
                System.out.println("The student with the age " + currentAge + " can vote.");
            } else {
                System.out.println("The student with the age " + currentAge + " cannot vote.");
            }
        }
    }
}