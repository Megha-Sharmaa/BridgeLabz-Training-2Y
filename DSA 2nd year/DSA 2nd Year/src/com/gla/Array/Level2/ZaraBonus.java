package com.gla.Array.Level2;
import java.util.Scanner;
public class ZaraBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] employee = new double[10][2];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details of Employee " + (i + 1));

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            System.out.print("Enter years of service: ");
            double years = sc.nextDouble();
            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }

            employee[i][0] = salary;
            employee[i][1] = years;
        }
        for (int i = 0; i < 10; i++) {

            if (employee[i][1] > 5) {
                bonus[i] = employee[i][0] * 0.05;
            } else {
                bonus[i] = employee[i][0] * 0.02;
            }

            newSalary[i] = employee[i][0] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += employee[i][0];
            totalNewSalary += newSalary[i];
        }
        System.out.println("\nEmployee Salary Details:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.println("Old Salary = " + employee[i][0]);
            System.out.println("Bonus = " + bonus[i]);
            System.out.println("New Salary = " + newSalary[i]);
            System.out.println();
        }
        System.out.println("Total Bonus Payout = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}
