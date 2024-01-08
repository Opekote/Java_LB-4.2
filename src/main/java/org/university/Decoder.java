package org.university;

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