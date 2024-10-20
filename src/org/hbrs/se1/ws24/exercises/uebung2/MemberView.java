package org.hbrs.se1.ws24.exercises.uebung2;

import java.util.List;

public class MemberView {

    public void dump(List<Member> list) {
        for(Member m: list) {
            System.out.println(m.toString());
        }
    }
}
