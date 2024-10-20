package org.hbrs.se1.ws24.exercises.uebung2;

public class Client {

    public static void main() throws ContainerException {
        Container container = Container.getInstance();
        Member a = new ConcreteMember(1);
        Member b = new ConcreteMember(2);
        Member c = new ConcreteMember(3);
        container.addMember(a);
        container.addMember(b);
        container.addMember(c);
        container.getCurrentList();
        MemberView view = new MemberView();
        view.dump(container.getCurrentList());

    }

}
