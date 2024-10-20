package org.hbrs.se1.ws24.exercises.uebung2;

import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.exercises.uebung3.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container {


private ArrayList<Member> list = new ArrayList<>();

private static Container instance;
private PersistenceStrategy<Member> persistenceStrategy;

private Container() {
}

public static Container getInstance() {
    if (instance == null) {
        instance = new Container();
    }
    return instance;
}

public void store() throws PersistenceException {
    if (persistenceStrategy == null) {
        throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "No strategy is set");
    }
    persistenceStrategy.save(list);

}
public void load() throws PersistenceException {
    if (persistenceStrategy == null) {
        throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "No strategy is set");
    }
    List<Member> loadedMembers = persistenceStrategy.load();
    list.clear();
    list.addAll(loadedMembers);
}

public void setPersistenceStrategy(PersistenceStrategy<Member> strategy) {
    this.persistenceStrategy = strategy;
}


public void addMember(Member member) throws ContainerException {
    if (list.contains(member)) {
        throw new ContainerException(member.getID());
    }
    list.add(member);
}

public String deleteMember(Integer id) {
    if (list.isEmpty()) {
        return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden";
    } else {
        for(Iterator<Member> it = list.iterator(); it.hasNext();) {
            Member m = it.next();
            if(m.getID().equals(id)) {
                it.remove();
                return "Das Member-Objekt mit der ID " + id + " wurde gelöscht";
            }
        }
    }
    return "Das Member-Objekt mit der ID " + id + " ist nicht vorhanden";
}

public List<Member> getCurrentList() {
    return list;
}

public int size() {
    return list.size();
}

}
