package org.hbrs.se1.ws24.exercises.uebung1.view;


import com.sun.java.accessibility.util.Translator;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.exercises.uebung1.control.translatorFactory;

public class Client  extends translatorFactory {

		/**
		 * Methode zur Ausgabe einer Zahl auf der Console
		 * (auch bezeichnet als CLI, Terminal)
		 *
		 */
		 void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung (nur) gegen das Interface Translator gewuenscht!
			 GermanTranslator trans = translatorFactory.createGermanTranslator();
			 String number = trans.translateNumber(aNumber);

			 System.out.println("Das Ergebnis der Berechnung: " + number +
					"[das Ergebnis an dieser Stelle]" );

		 }

}





