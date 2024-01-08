package org.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoderTest {
    Decoder decoder;

    @BeforeEach
     void setUp(){
        decoder = new Decoder();
    }

    @Test
    public void testDecodeVowels() {
        assertEquals("testing", decoder.decodeVowels("t2st3ng"));
        assertEquals("hello", decoder.decodeVowels("h2ll4"));
        assertEquals("hi", decoder.decodeVowels("h3"));
    }

    @Test
    public void testDecodeConsonant() {
        assertEquals("testing", decoder.decodeConsonant("vetviph"));
        assertEquals("apple", decoder.decodeConsonant("bqqme"));
    }

    @Test
    public void testIsVowel() {
        assertTrue(decoder.isVowel('a'));
        assertTrue(decoder.isVowel('e'));
        assertTrue(decoder.isVowel('i'));
        assertTrue(decoder.isVowel('o'));
        assertTrue(decoder.isVowel('u'));

        assertFalse(decoder.isVowel('b'));
        assertFalse(decoder.isVowel('c'));
        assertFalse(decoder.isVowel('d'));
        assertFalse(decoder.isVowel('x'));
        assertFalse(decoder.isVowel('y'));
        assertFalse(decoder.isVowel('z'));
    }

    @Test
    public void testDecodeSentence() {
        assertEquals("testing testing hello", decoder.decodeSentence("t2st3ng vetviph h2ll4"));
    }
}

