package com.gla.Array.Level2;
import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {

            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double empSalary = sc.nextDouble();

            System.out.print("Enter years of service: ");
            double service = sc.nextDouble();

            if (empSalary <= 0 || service < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }

            salary[i] = empSalary;
            yearsOfService[i] = service;
        }

        for (int i = 0; i < 10; i++) {

            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nTotal Bonus = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}
