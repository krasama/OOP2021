package cz.cvut.mk.model;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post){
        this.posts.add(post);
    }

    @Override
    public String toString() {
        return "Feed{" +
                "posts=" + posts +
                '}';
    }
}
