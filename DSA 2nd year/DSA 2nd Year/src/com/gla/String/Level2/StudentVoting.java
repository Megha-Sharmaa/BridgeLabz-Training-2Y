package com.gla.String.Level2;
import java.util.Scanner;
public class StudentVoting {
    public static int[] generateAges(int n) {

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = (int) (Math.random() * 100);
        }

        return ages;
    }

    public static String[][] checkVoting(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    public static void display(String[][] data) {

        System.out.println("Age\tCan Vote");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] ages = new int[10];

        System.out.println("Enter age of 10 students:");

        for (int i = 0; i < 10; i++) {
            ages[i] = sc.nextInt();
        }

        String[][] result = checkVoting(ages);

        display(result);

        sc.close();
    }
}
