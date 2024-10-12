package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.Iterator;

public class Container {


java.util.ArrayList<Member> list = new java.util.ArrayList<>();

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

public void dump() {
    for(Member m: list) {
        System.out.println("Member (ID ="+m.getID()+")");
    }
}
public int size() {
    return list.size();
}

}
