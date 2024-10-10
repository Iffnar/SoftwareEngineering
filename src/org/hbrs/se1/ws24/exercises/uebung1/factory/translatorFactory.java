package org.hbrs.se1.ws24.exercises.uebung1.factory;

import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;

public class translatorFactory {

    // Factory Method zur Erzeugung eines Translator-Objekts
    public static Translator createGermanTranslator() {
        GermanTranslator translator = new GermanTranslator();
        translator.setDate("Okt/2024"); // Setzen des Datums
        return translator;
    }
}
