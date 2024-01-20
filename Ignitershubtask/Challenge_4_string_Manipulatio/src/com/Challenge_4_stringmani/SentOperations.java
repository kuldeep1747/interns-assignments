package com.Challenge_4_stringmani;

import java.util.Scanner;

public class SentOperations {

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a sentence
        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine();

        // 1. Count the number of words in the sentence
        int wordCount = countWords(inputSentence);
        System.out.println("Number of words in the sentence: " + wordCount);

        // 2. Reverse the order of words in the sentence
        String reversedSentence = reverseWords(inputSentence);
        System.out.println("Reversed sentence: " + reversedSentence);

        // 3. Replace all spaces with hyphens ('-')
        String hyphenatedSentence = replaceSpacesWithHyphens(inputSentence);
        System.out.println("Sentence with spaces replaced by hyphens: " + hyphenatedSentence);

        // Close the scanner
        scanner.close();
    }

    // Function to count the number of words in a sentence
    private static int countWords(String sentence) {
        String[] words = sentence.split("\\s+");
        return words.length;
    }

    // Function to reverse the order of words in a sentence
    private static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }

        return reversedSentence.toString().trim();
    }

    // Function to replace all spaces with hyphens in a sentence
    private static String replaceSpacesWithHyphens(String sentence) {
        return sentence.replaceAll("\\s", "-");
    }
}
