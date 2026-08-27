package com.gla.Array.Level2;
import java.util.Scanner;
public class StudentsGrades2 {
    public static void main(String[] args){

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of students: ");
            int n = sc.nextInt();
            double[][] marks = new double[n][3];

            double[] percentage = new double[n];
            char[] grade = new char[n];
            for (int i = 0; i < n; i++) {
                System.out.println("\nStudent " + (i + 1));

                for (int j = 0; j < 3; j++) {
                    String subject;

                    if (j == 0)
                        subject = "Physics";
                    else if (j == 1)
                        subject = "Chemistry";
                    else
                        subject = "Maths";

                    System.out.print("Enter " + subject + " marks: ");
                    marks[i][j] = sc.nextDouble();
                    while (marks[i][j] < 0) {
                        System.out.print("Marks cannot be negative. Enter again: ");
                        marks[i][j] = sc.nextDouble();
                    }
                }
                double total = 0;

                for (int j = 0; j < 3; j++) {
                    total += marks[i][j];
                }

                percentage[i] = total / 3.0;
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
            System.out.println("\n------------------------------------------------------------------");
            System.out.printf("%-10s %-10s %-10s %-10s %-15s %-5s%n",
                    "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
            System.out.println("------------------------------------------------------------------");

            for (int i = 0; i < n; i++) {
                System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15.2f %-5c%n",
                        i + 1,
                        marks[i][0],
                        marks[i][1],
                        marks[i][2],
                        percentage[i],
                        grade[i]);
            }

            sc.close();
        }
    }


