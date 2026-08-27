package com.gla.String.Level3;
import java.util.Scanner;
public class BMICalculator {
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightMeter = heightCm / 100;
        double bmi = weight / (heightMeter * heightMeter);

        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{
                String.valueOf(heightCm),
                String.valueOf(weight),
                String.format("%.2f", bmi),
                status
        };
    }

    public static String[][] calculateAllBMI(double[][] data) {
        String[][] result = new String[10][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiResult = calculateBMI(weight, height);

            for (int j = 0; j < 4; j++) {
                result[i][j] = bmiResult[j];
            }
        }

        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < data.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                            data[i][0] + "\t\t" +
                            data[i][1] + "\t\t" +
                            data[i][2] + "\t" +
                            data[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = calculateAllBMI(data);

        System.out.println("\nBMI Report");
        display(result);

        sc.close();
    }
}
