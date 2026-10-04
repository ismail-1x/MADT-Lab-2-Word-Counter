package com.example.mywordcalculation;

public class TextCounter {

    public int countCharacters(String text) {
        return text.length();
    }

    public int countNumbers(String text) {
        int count = 0;

        // Loop through every character in the text
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            // Check if the character is a number
            if (Character.isDigit(currentChar)) {
                count++;
            }
        }

        return count;
    }

    public int countWords(String text) {
        // If the text is empty, return 0 words
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }


        String[] words = text.trim().split("[ ,.]+");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }


    public int countSentences(String text) {
        int count = 0;


        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (currentChar == '.' || currentChar == '!' || currentChar == '?') {
                count++;
            }
        }

        return count;
    }
}