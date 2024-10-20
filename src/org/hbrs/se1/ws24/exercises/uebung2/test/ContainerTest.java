package org.hbrs.se1.ws24.exercises.uebung2.test;

import org.hbrs.se1.ws24.exercises.uebung2.ConcreteMember;
import org.hbrs.se1.ws24.exercises.uebung2.Container;
import org.hbrs.se1.ws24.exercises.uebung2.ContainerException;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ContainerTest {

    private Container container;
    private Member a;
    private Member b;


    @BeforeEach void init() {
        container = Container.getInstance();
        a = new ConcreteMember(1);
        b = new ConcreteMember(2);
    }
    @Test void testAddMember() throws ContainerException {
        container.addMember(a);
        Assertions.assertEquals(1, container.size());

    }
    @Test void testAddSecondMember() throws ContainerException {
        container.addMember(a);
        container.addMember(b);
        Assertions.assertEquals(2, container.size());
    }

    @Test void testAddDuplicateMember() throws ContainerException {
        container.addMember(a);
        Assertions.assertThrows(ContainerException.class, () -> {
            container.addMember(a);
        });
    }
    @Test void testDeleteExistingMember() throws ContainerException {
        container.addMember(a);
        container.deleteMember(1);
        Assertions.assertEquals(0, container.size());
    }
    @Test void testDeleteNonExistingMember() {
        Assertions.assertEquals("Das Member-Objekt mit der ID 1 ist nicht vorhanden", container.deleteMember(1));
    }
    @Test
    void testDeleteAllMembers() throws ContainerException {
        container.addMember(a);
        container.addMember(b);
        container.deleteMember(1);
        container.deleteMember(2);
        Assertions.assertEquals(0, container.size(), "Container should be empty after deleting all members.");
    }

    @Test void testDump() throws ContainerException {
        container.addMember(a);
        container.addMember(b);

    }
    @Test void testSize() throws ContainerException {
        container.addMember(a);
        Assertions.assertEquals(1, container.size());
        container.deleteMember(1);
        Assertions.assertEquals(0, container.size());
    }
}
