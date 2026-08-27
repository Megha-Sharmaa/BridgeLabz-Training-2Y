package com.gla.String.Level2;
import java.util.Scanner;
public class SplitWords {
    public static int findLength(String text) {
        int count = 0;

        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        return count;
    }

    public static String[] splitWords(String text) {
        int length = findLength(text);
        int wordCount = 0;
        boolean insideWord = false;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (ch == ' ') {
                insideWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        String word = "";

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word = word + ch;
            } else if (!word.equals("")) {
                words[wordIndex] = word;
                wordIndex++;
                word = "";
            }
        }

        if (!word.equals("")) {
            words[wordIndex] = word;
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] userWords = splitWords(text);
        String[] builtInWords = text.split(" ");

        boolean result = compareArrays(userWords, builtInWords);

        System.out.println("Words using user-defined method:");

        for (String word : userWords) {
            System.out.println(word);
        }

        System.out.println("Words using split():");

        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("Both results are same: " + result);

        sc.close();
    }
}
