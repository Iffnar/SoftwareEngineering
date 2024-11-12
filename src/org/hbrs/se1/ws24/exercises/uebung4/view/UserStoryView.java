package org.hbrs.se1.ws24.exercises.uebung4.view;

import org.hbrs.se1.ws24.exercises.uebung4.UserStory;

import java.util.List;
import java.util.stream.Collectors;

public class UserStoryView {

    public void dump(List<UserStory> liste, String suchbegriff) {
        System.out.println("Ausgabe aller UserStory-Objekte für das Projekt: " + suchbegriff);

        // Filter und Sortierung nach Priorität
        List<UserStory> reducedList = liste.stream()
                .filter(story -> story.getProjekt().equalsIgnoreCase(suchbegriff)) // Filter nach Projekt
                .sorted((s1, s2) -> Double.compare(s2.getPrio(), s1.getPrio())) // Sortierung nach Priorität absteigend
                .collect(Collectors.toList());

        // Ausgabe
        for (UserStory story : reducedList) {
            System.out.println(story);
        }
    }
}
