package com.gla.String.Level1;
import java.util.Scanner;
public class StringCharacters {

        public static char[] getCharacters(String text) {

            char[] characters = new char[text.length()];

            for (int i = 0; i < text.length(); i++) {
                characters[i] = text.charAt(i);
            }

            return characters;
        }

        public static boolean compareArrays(char[] arr1, char[] arr2) {

            if (arr1.length != arr2.length) {
                return false;
            }

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    return false;
                }
            }

            return true;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String text = sc.next();


            char[] userArray = getCharacters(text);


            char[] builtInArray = text.toCharArray();


            boolean result = compareArrays(userArray, builtInArray);

            System.out.println("Characters using user-defined method:");
            for (char ch : userArray) {
                System.out.print(ch + " ");
            }

            System.out.println();

            System.out.println("Characters using toCharArray():");
            for (char ch : builtInArray) {
                System.out.print(ch + " ");
            }

            System.out.println();
            System.out.println("Both arrays are same: " + result);

            sc.close();
        }
    }

