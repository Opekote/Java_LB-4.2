package org.university;




public class Main {

    public static void main(String[] args) {

        Decoder decoder = new Decoder();

        // Example usage
        String encodedVowels = "t2st3ng";
        String decodedVowels = decoder.decodeVowels(encodedVowels);
        System.out.println("Decoded Vowels: " + decodedVowels);

        String encodedConsonants = "vetviph";
        String decodedConsonants = decoder.decodeConsonant(encodedConsonants);
        System.out.println("Decoded Consonants: " + decodedConsonants);
    }
}