# Decoder

The `Decoder` class provides methods for decoding messages encoded with different patterns. It includes functionality for decoding vowels, consonants, and entire sentences.

## Class Methods

### `decodeVowels(String input): String`

This method decodes a string by replacing numeric representations of vowels with the corresponding vowels. For example, "t2st3ng" becomes "testing".

### `decodeConsonant(String input): String`

This method decodes a string by replacing each consonant with its preceding consonant in the English alphabet, except for 'a', which remains unchanged. For example, "vetviph" becomes "testing".

### `decodeSentence(String sentence): String`

This method decodes an entire sentence by splitting it into words and decoding each word using either the `decodeVowels` or `decodeConsonant` method based on the presence of numeric characters. The decoded words are then concatenated to form the decoded sentence.

### `isVowel(char toCheck): boolean`

This helper method checks if a given character is a vowel.

## Unit Tests

The `DecoderTest` class contains JUnit tests for each method in the `Decoder` class.

### `testDecodeVowels()`

Tests the `decodeVowels` method by asserting that the decoded strings match the expected results.

### `testDecodeConsonant()`

Tests the `decodeConsonant` method by asserting that the decoded strings match the expected results.

### `testIsVowel()`

Tests the `isVowel` helper method by asserting that the method correctly identifies vowels and non-vowels.

### `testDecodeSentence()`

Tests the `decodeSentence` method by asserting that the decoded sentence matches the expected result.

## Setup

In the `DecoderTest` class, a `Decoder` instance is created in the `setUp` method to facilitate testing.
