package org.university;

import java.util.ArrayList;
import java.util.List;

public class Decoder {

    public String decodeVowels(String input) {
        String vowels = "aeiou";
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                int position = (int) input.charAt(i) - (int) '0';
                input = input.replace(input.charAt(i), vowels.charAt(position - 1));
            }
        }
        return input;
    }

    public String decodeConsonant(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!isVowel(Character.toLowerCase(input.charAt(i)))) {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'A') {
                    sb.append(input.charAt(i));
                } else {
                    char prevConsonant = findPreviousConsonant(Character.toLowerCase(input.charAt(i)));
                    sb.append(prevConsonant);
                }
            } else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public String decodeSentence(String sentence) {
        String[] words = sentence.split("[\\s,]+"); // Розділити предложення на слова за пробілами та комами
        List<String> decodedWords = new ArrayList<>();

        for (String word : words) {
            if (word.matches(".*\\d.*")) {
                // Якщо слово містить цифри, використовуйте decodeVowels
                decodedWords.add(decodeVowels(word));
            } else {
                // Інакше використовуйте decodeConsonant
                decodedWords.add(decodeConsonant(word));
            }
        }

        // Зібрати розшифроване предложення
        StringBuilder sb = new StringBuilder();
        for (String decodedWord : decodedWords) {
            sb.append(decodedWord).append(" ");
        }

        // Видалити останній пробіл, який може бути доданий в кінці
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private char findPreviousConsonant(char c) {
        if (c == 'b') {
            return 'a'; // Special case for 'b'.
        } else if (c == 'z') {
            return 'z'; // Special case for 'z' since there's no next consonant.
        } else {
            // Find the previous consonant by decrementing the character value.
            char prevConsonant = (char) (c - 1);
            while (isVowel(prevConsonant)) {
                prevConsonant = (char) (prevConsonant - 1);
            }
            return prevConsonant;
        }
    }

    public boolean isVowel(char toCheck) {
        String vowels = "aeiou";
        return vowels.contains(String.valueOf(toCheck));
    }

}
