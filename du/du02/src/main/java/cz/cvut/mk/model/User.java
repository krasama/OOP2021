package cz.cvut.mk.model;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer<Post>, Observable<Post> {

    private final String username;
    private final List<User> friends = new ArrayList<>();
    private final List<Post> profilePosts = new ArrayList<>();
    private final Feed feed = new Feed();
    private final List<Group> groups = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public void addPost(String text){
        Post post = new Post(this, text);
        this.profilePosts.add(post);
        this.notifyFriends(post);
    }

    public String getUsername() {
        return username;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public void onMessage(Post post) {
        this.feed.addPost(post);
    }

    @Override
    public void addFriend(User user) {
        this.friends.add(user);
        user.getFriends().add(this);
    }

    @Override
    public void notifyFriends(Post post) {
        this.friends.forEach(user -> user.onMessage(post));
    }

    @Override
    public String toString() {
        return "username=" + username +
                ", feed=" + feed+
                ", posts" + profilePosts;
    }
}
