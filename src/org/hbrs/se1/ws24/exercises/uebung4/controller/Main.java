package org.hbrs.se1.ws24.exercises.uebung4.controller;

import org.hbrs.se1.ws24.exercises.uebung4.Container;
import org.hbrs.se1.ws24.exercises.uebung4.controller.InputDialog;
import org.hbrs.se1.ws24.solutions.uebung3.ContainerException;

public class Main {

    public static void main(String[] args) throws ContainerException {
        Container con = Container.getInstance();
        InputDialog dialog = new InputDialog();
        dialog.startEingabe();
    }

}
