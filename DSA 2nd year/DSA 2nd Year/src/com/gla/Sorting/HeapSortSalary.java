package com.gla.Sorting;
import java.util.Scanner;
public class HeapSortSalary {
    public static void heapSort(int[] salary) {
        int n = salary.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }
    }

    public static void heapify(int[] salary, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && salary[left] > salary[largest]) {
            largest = left;
        }

        if (right < n && salary[right] > salary[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = salary[i];
            salary[i] = salary[largest];
            salary[largest] = swap;

            heapify(salary, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of applicants: ");
        int n = sc.nextInt();

        int[] salary = new int[n];

        System.out.println("Enter expected salary demands:");
        for (int i = 0; i < n; i++) {
            salary[i] = sc.nextInt();
        }

        heapSort(salary);

        System.out.println("Sorted Salary Demands:");
        for (int s : salary) {
            System.out.print(s + " ");
        }

        sc.close();
    }
}


