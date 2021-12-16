package cz.cvut.mk;

import cz.cvut.mk.model.Group;
import cz.cvut.mk.model.SocialNetwork;
import cz.cvut.mk.model.User;

public class Application {

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();

        User u1 = new User("Karel");
        User u2 = new User("Honza");
        User u3 = new User("Vojta");
        User u4 = new User("Martin");

        socialNetwork.registerUser(u1);
        socialNetwork.registerUser(u2);
        socialNetwork.registerUser(u3);
        socialNetwork.registerUser(u4);

        Group kocky = new Group("Kočičkáři");
        Group psi = new Group("Pejskaři");

        socialNetwork.registerGroup(kocky);
        socialNetwork.registerGroup(psi);

        u1.addFriend(u2);
        u1.addFriend(u3);
        u1.addFriend(u4);

        u2.addFriend(u3);
        u2.addFriend(u4);

        psi.addFriend(u3);
        psi.addFriend(u4);

        kocky.addFriend(u1);
        kocky.addFriend(u2);

        u3.addPost("Základní otázka na život vezmír a vůbec?");
        psi.addPost(u3, "Musíme postavit Hlubinu myšlení");

        u1.addPost("Odpověď je 42");
        kocky.addPost(u2, "Hloupost, ještě by nás ovládaly myši");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);


    }
}
