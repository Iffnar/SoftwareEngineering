package org.hbrs.se1.ws24.exercises.uebung4.test;
import org.hbrs.se1.ws24.exercises.uebung4.controller.InputDialog;
import org.hbrs.se1.ws24.solutions.uebung3.ContainerException;
import org.hbrs.se1.ws24.solutions.uebung3.persistence.PersistenceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.UserStory;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserStoryTest {

        private Container container;

        @BeforeEach
        void setUp() throws PersistenceException {
            container = Container.getInstance();
            container.deleteAllMembers(); // Alle Elemente vorher löschen für saubere Tests
        }

        @Test
        void testAddUserStory() throws ContainerException {
            UserStory story = new UserStory(1, "Test Story", "Akzeptanz", 5, 3, 1, "ProjektA", 10);
            container.addUserStory(story);
            assertEquals(1, container.size());
        }

        @Test
        void testAddDuplicateUserStory() {
            UserStory story1 = new UserStory(1, "Story1", "Akzeptanz", 5, 3, 1, "ProjektA", 10);
            UserStory story2 = new UserStory(1, "Story2", "Akzeptanz", 2, 4, 1, "ProjektB", 8);

            assertThrows(ContainerException.class, () -> {
                container.addUserStory(story1);
                container.addUserStory(story2); // Sollen Ausnahme werfen
            });
        }

        @Test
        void testDeleteUserStory() throws ContainerException {
            UserStory story = new UserStory(2, "Test Story", "Akzeptanz", 5, 3, 1, "ProjektA", 10);
            container.addUserStory(story);
            assertEquals("Member mit der ID 2 konnte geloescht werden", container.deleteMember(2));
            assertEquals(0, container.size());
        }

        @Test
        void testStoreAndLoad() throws PersistenceException, ContainerException {
            UserStory story = new UserStory(3, "Test Story", "Akzeptanz", 5, 3, 1, "ProjektA", 10);
            container.addUserStory(story);

            container.store();
            container.deleteAllMembers();
            assertEquals(0, container.size());

            container.load();
            assertEquals(1, container.size());
            assertEquals(3, container.getCurrentList().get(0).getId());
        }
    }

    class InputDialogTest {

        private InputDialog dialog;

        @BeforeEach
        void setUp() {
            dialog = new InputDialog();
        }

        @Test
        void testStartEingabeWithStoreAndLoad() {
            // Für diesen Test können Sie ein Mock-Objekt für Scanner verwenden
            // oder den Standard-Eingabeaufforderungsfluss testen, indem man `System.in` umleitet.
            // Dies erfordert jedoch eine komplexere Setup-Anpassung.
        }
    }

}
