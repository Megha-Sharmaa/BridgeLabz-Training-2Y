package com.gla.Array.Level2;
import java.util.Scanner;
public class StudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Physics marks (out of 100): ");
            physics[i] = sc.nextDouble();
            while (physics[i] < 0) {
                System.out.print("Marks cannot be negative. Enter again: ");
                physics[i] = sc.nextDouble();
            }
            System.out.print("Enter Chemistry marks (out of 100): ");
            chemistry[i] = sc.nextDouble();
            while (chemistry[i] < 0) {
                System.out.print("Marks cannot be negative. Enter again: ");
                chemistry[i] = sc.nextDouble();
            }

            System.out.print("Enter Maths marks (out of 100): ");
            maths[i] = sc.nextDouble();
            while (maths[i] < 0) {
                System.out.print("Marks cannot be negative. Enter again: ");
                maths[i] = sc.nextDouble();
            }
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }
        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-5s%n",
                "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15.2f %-5c%n",
                    (i + 1),
                    physics[i],
                    chemistry[i],
                    maths[i],
                    percentage[i],
                    grade[i]);
        }

        sc.close();
    }
}
