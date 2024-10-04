package org.hbrs.se1.ws24.tests.uebung1;


import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class GermanTranslatorTest {

    @Test
    public void testPositiveNumbers() {
        GermanTranslator translator = new GermanTranslator();

        assertEquals("Eins", translator.translateNumber(1));
        assertEquals("Zwei", translator.translateNumber(2));
        assertEquals("Drei", translator.translateNumber(3));
        assertEquals("Vier", translator.translateNumber(4));
        assertEquals("Fünf", translator.translateNumber(5));
        assertEquals("Sechs", translator.translateNumber(6));
        assertEquals("Sieben", translator.translateNumber(7));
        assertEquals("Acht", translator.translateNumber(8));
        assertEquals("Neun", translator.translateNumber(9));
        assertEquals("Zehn", translator.translateNumber(10));
    }
    @Test
    public void testNegativeNumbers() {
        GermanTranslator translator = new GermanTranslator();

        assertEquals("Übersetzung nicht möglich", translator.translateNumber(-1));
        assertEquals("Übersetzung nicht möglich", translator.translateNumber(-999));
        assertEquals("Übersetzung nicht möglich", translator.translateNumber(999));
        assertEquals("Übersetzung nicht möglich", translator.translateNumber(0));

    }
    @Test
    public void testBoundaryCases() {
        GermanTranslator translator = new GermanTranslator();

        assertEquals("Übersetzung nicht möglich", translator.translateNumber(1));
        assertEquals("Übersetzung nicht möglich", translator.translateNumber(11));
    }
}