package org.hbrs.se1.ws24.exercises.uebung4.controller;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategyStream;
import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStory;
import org.hbrs.se1.ws24.exercises.uebung4.view.UserStoryView;
import org.hbrs.se1.ws24.solutions.uebung3.ContainerException;
import org.hbrs.se1.ws24.solutions.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.solutions.uebung3.persistence.PersistenceStrategy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputDialog {

    private final Container container = Container.getInstance();
    private final UserStoryView view = new UserStoryView();

    public InputDialog() {
        container.setPersistenceStrategie((PersistenceStrategy) new PersistenceStrategyStream());
    }

    public void startEingabe() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Eingabe-Dialog für User Stories");

        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            String[] command = input.split(" ");

            switch (command[0].toLowerCase()) {
                case "help":
                    System.out.println("Befehle: enter, store, load, dump, exit, help");
                    break;

                case "store":
                    try {
                        container.store();
                        System.out.println("User Stories erfolgreich gespeichert.");
                    } catch (PersistenceException e) {
                        System.out.println("Fehler beim Speichern: " + e.getMessage());
                    }
                    break;

                case "load":
                    try {
                        container.load();
                        System.out.println("User Stories erfolgreich geladen.");
                    } catch (PersistenceException e) {
                        System.out.println("Fehler beim Laden: " + e.getMessage());
                    }
                    break;

                case "dump":
                    System.out.print("Projektfilter eingeben: ");
                    String projectFilter = sc.nextLine();
                    view.dump(container.getCurrentList(), projectFilter);
                    break;

                case "enter":
                    try {
                        UserStory story = readUserStoryFromInput(sc);
                        container.addUserStory(story);
                        System.out.println("User Story erfolgreich hinzugefügt.");
                    } catch (ContainerException e) {
                        System.out.println("Fehler: " + e.getMessage());
                    } catch (IllegalArgumentException | InputMismatchException e) {
                        System.out.println("Fehlerhafte Eingabe: " + e.getMessage());
                        sc.nextLine(); // Eingabepuffer leeren
                    }
                    break;

                case "exit":
                    System.out.println("Programm beendet.");
                    return;

                default:
                    System.out.println("Unbekannter Befehl. Verwenden Sie 'help' für eine Liste der Befehle.");
                    break;
            }
        }
    }

    private UserStory readUserStoryFromInput(Scanner sc) {
        System.out.println("User Story-Daten eingeben:");

        System.out.print("ID: ");
        int id = promptForPositiveInt(sc, "ID");

        System.out.print("Titel: ");
        String titel = sc.nextLine();

        System.out.print("Akzeptanzkriterien: ");
        String akzeptanzKriterien = sc.nextLine();

        int aufwand = promptForPositiveInt(sc, "Aufwand");
        int risk = promptForPositiveInt(sc, "Risiko");
        int mehrwert = promptForPositiveInt(sc, "Mehrwert");
        int strafe = promptForPositiveInt(sc, "Strafe");

        System.out.print("Projekt: ");
        String projekt = sc.nextLine();

        return new UserStory(id, titel, akzeptanzKriterien, strafe, aufwand, risk, projekt, mehrwert);
    }

    private int promptForPositiveInt(Scanner sc, String fieldName) {
        int value;
        while (true) {
            System.out.print(fieldName + " (positive Zahl): ");
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value >= 0) break;
                System.out.println(fieldName + " muss positiv sein.");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte eine Ganzzahl eingeben.");
            }
        }
        return value;
    }
}
