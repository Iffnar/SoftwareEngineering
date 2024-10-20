package org.hbrs.se1.ws24.exercises.uebung2.test;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.*;
import org.hbrs.se1.ws24.exercises.uebung2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class ContainerStrategyTest {

    private Container container;
    @BeforeEach
    public void setUp() {
        container = Container.getInstance();
        container.setPersistenceStrategy(null); // Reset the strategy to null before each test
    }

    @Test
    public void testNoStrategySet() {
        PersistenceException exception = assertThrows(PersistenceException.class, () -> {
            container.store(); // Versucht zu speichern, obwohl keine Strategie gesetzt ist
        });
        assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, exception.getExceptionTypeType());
    }
    @Test
    public void testDBMongoStrategy() throws PersistenceException, ContainerException {
        PersistenceStrategy<Member> strategy = new PersistenceStrategyMongoDB();
        container.setPersistenceStrategy(strategy);

        Member a = new ConcreteMember(1);
        container.addMember(a);
        assertThrows(UnsupportedOperationException.class, () -> {container.store();});
    }

    @Test
    public void testInvalidFileLocation() {
        PersistenceStrategyStream strategy = new PersistenceStrategyStream();
        strategy.setLocation("invalid/path/to/file.ser"); // Set an invalid path
        container.setPersistenceStrategy(strategy);

        // Now we want to check that saving with this invalid path throws an exception
        PersistenceException exception = assertThrows(PersistenceException.class, () -> {
            container.store(); // This should trigger the exception
        });

        // Verify that the exception type is what we expect
        assertEquals(PersistenceException.ExceptionType.locationNotValid,
                exception.getExceptionTypeType());
    }
    @Test
    public void testRoundTrip() throws PersistenceException, ContainerException {
        // 1. Setze die Strategie
        PersistenceStrategyStream strategy = new PersistenceStrategyStream();
        strategy.setLocation("C:\\Users\\Iffnar\\IdeaProjects\\SoftwareEngineering\\src\\org\\hbrs\\se1\\ws24\\exercises\\uebung3\\objects\\fileName"); // Full file path including file name
        container.setPersistenceStrategy(strategy);

        // 2. Füge ein Member hinzu
        Member a = new ConcreteMember(1);
        container.addMember(a);
        assertEquals(1, container.size());

        // 3. Speichere den Container
        container.store();

        //4. Lösche den Container
        container.deleteMember(1);
        assertEquals(0, container.size());

        //5. Lade den Container
        container.load();
        List<Member> list = container.getCurrentList();

        //6. Überprüfe, ob der Member wieder da ist
        assertEquals(1, list.size());
        assertEquals(1, list.get(0).getID());


    }






}
