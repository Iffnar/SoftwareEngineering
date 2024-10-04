package org.hbrs.se1.ws24.exercises.uebung1.view;


import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;
import org.hbrs.se1.ws24.exercises.uebung1.factory.translatorFactory;

public class Client  extends translatorFactory {


		 void display( int aNumber ){

			 Translator trans = translatorFactory.createGermanTranslator();
			 String number = trans.translateNumber(aNumber);

			 System.out.println("Das Ergebnis der Berechnung: " + number +
					"[das Ergebnis an dieser Stelle]" );

		 }

}





