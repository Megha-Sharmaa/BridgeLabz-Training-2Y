package com.gla.LinearSearch;

public class SearchWord {
    public static String findSentence(String[] sentences, String word) {
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].contains(word)) {
                return sentences[i];
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is a programming language",
                "Python is easy to learn",
                "Java is used for backend development",
                "C++ is also a programming language"
        };

        String word = "Java";

        String result = findSentence(sentences, word);

        System.out.println(result);
    }
}
