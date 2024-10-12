package org.hbrs.se1.ws24.exercises.uebung2;

public class ConcreteMember implements Member{

    private Integer id;

    public ConcreteMember(int id) {
        this.id = id;

    }

    @Override
    public Integer getID() {
        return id;
    }
}
