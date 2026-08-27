package com.gla.String.Level2;
import java.util.Scanner;
public class CustomTrim {
    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);

        String userDefinedTrim =
                createSubstring(text, indexes[0], indexes[1]);

        String builtInTrim = text.trim();

        boolean result =
                compareStrings(userDefinedTrim, builtInTrim);

        System.out.println("Using user-defined method: [" +
                userDefinedTrim + "]");

        System.out.println("Using trim(): [" +
                builtInTrim + "]");

        System.out.println("Both results are same: " + result);

        sc.close();
    }
}
