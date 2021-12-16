package cz.cvut.mk.model;

import java.util.ArrayList;
import java.util.List;

public class Group implements Observable<Post>{
    private final String name;
    private final List<User> users = new ArrayList<>();
    private final List<Post> posts = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPost(User user, String text){
        Post post = new Post(user, this, text);
        this.posts.add(post);
        this.notifyFriends(post);
    }

    @Override
    public void addFriend(User user) {
        this.users.add(user);
        user.getGroups().add(this);
    }

    @Override
    public void notifyFriends(Post post) {
        this.users.forEach(user -> user.onMessage(post));
    }
}
