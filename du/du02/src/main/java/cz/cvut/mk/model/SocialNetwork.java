package cz.cvut.mk.model;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private final List<User> users = new ArrayList<>();
    private final List<Group> groups = new ArrayList<>();

    public void registerUser(User user){
        users.add(user);
    }

    public void registerGroup(Group group){
       groups.add(group);
    }
}
