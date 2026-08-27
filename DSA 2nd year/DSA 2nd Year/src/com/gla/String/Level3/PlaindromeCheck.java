package com.gla.String.Level3;
import java.util.Scanner;
public class PlaindromeCheck {
    public static boolean checkPalindrome(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
    public static boolean checkPalindromeRecursive(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return checkPalindromeRecursive(text, start + 1, end - 1);
    }
    public static char[] reverseString(String text) {

        char[] reverse = new char[text.length()];

        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {

            reverse[index] = text.charAt(i);
            index++;
        }

        return reverse;
    }
    public static boolean checkPalindromeUsingArray(String text) {

        char[] original = text.toCharArray();

        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        if (checkPalindrome(text)) {
            System.out.println("Logic 1: Palindrome");
        } else {
            System.out.println("Logic 1: Not Palindrome");
        }
        if (checkPalindromeRecursive(text, 0, text.length() - 1)) {
            System.out.println("Logic 2: Palindrome");
        } else {
            System.out.println("Logic 2: Not Palindrome");
        }
        if (checkPalindromeUsingArray(text)) {
            System.out.println("Logic 3: Palindrome");
        } else {
            System.out.println("Logic 3: Not Palindrome");
        }


        sc.close();
    }

}
