package org.hbrs.se1.ws24.exercises.uebung1.control;

public abstract class translatorFactory implements Translator {

    public static GermanTranslator createGermanTranslator() {
        return new GermanTranslator() {
        };
    }
}
