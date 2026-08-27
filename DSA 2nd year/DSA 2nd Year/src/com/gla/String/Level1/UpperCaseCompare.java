package com.gla.String.Level1;
import java.util.Scanner;
public class UpperCaseCompare {

    public static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result = result + ch;
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

        String userDefinedResult = convertToUpperCase(text);
        String builtInResult = text.toUpperCase();

        boolean result = compareStrings(userDefinedResult, builtInResult);

        System.out.println("Using user-defined method: " + userDefinedResult);
        System.out.println("Using toUpperCase(): " + builtInResult);
        System.out.println("Both results are same: " + result);

        sc.close();
    }
}
