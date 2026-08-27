package com.gla.LinearSearch;
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        sb.append(str);

        String reversed = sb.reverse().toString();

        System.out.println(reversed);
    }
}
