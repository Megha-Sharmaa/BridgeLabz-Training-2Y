package com.gla.Array.Level2;
import java.util.Scanner;
public class BMICalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {

            System.out.println("\nPerson " + (i + 1));
            while (true) {
                System.out.print("Enter weight (kg): ");
                personData[i][0] = sc.nextDouble();

                if (personData[i][0] > 0) {
                    break;
                } else {
                    System.out.println("Invalid weight! Enter positive value.");
                }
            }
            while (true) {
                System.out.print("Enter height (m): ");
                personData[i][1] = sc.nextDouble();

                if (personData[i][1] > 0) {
                    break;
                } else {
                    System.out.println("Invalid height! Enter positive value.");
                }
            }
        }
        for (int i = 0; i < number; i++) {

            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            }
            else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            }
            else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            }
            else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nWeight\tHeight\tBMI\tStatus");

        for (int i = 0; i < number; i++) {
            System.out.println(personData[i][0] + "\t"
                    + personData[i][1] + "\t"
                    + personData[i][2] + "\t"
                    + weightStatus[i]);
        }

        sc.close();
    }
}
