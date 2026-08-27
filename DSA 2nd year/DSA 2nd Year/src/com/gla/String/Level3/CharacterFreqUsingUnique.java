package com.gla.String.Level3;
import java.util.Scanner;
public class CharacterFreqUsingUnique {
    public static char[] uniqueCharacters(String text) {

        char[] unique = new char[text.length()];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {

            boolean isUnique = true;

            for (int j = 0; j < i; j++) {

                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[index] = text.charAt(i);
                index++;
            }
        }
        char[] result = new char[index];

        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }

        return result;
    }
    public static String[][] findFrequency(String text) {

        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {

            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
        }

        return result;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        System.out.println("Character Frequency:");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " : " + result[i][1]);
        }

        sc.close();
    }

}
