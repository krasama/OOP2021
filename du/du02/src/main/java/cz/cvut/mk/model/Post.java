package cz.cvut.mk.model;


public class Post {

    private final User author;
    private Group group;
    private final String text;

    public Post(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public Post(User author, Group group, String text) {
        this.author = author;
        this.group = group;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author=" + author.getUsername() +
                ", group=" + (group != null ? group.getName() : "none") +
                ", text='" + text + '\'' +
                '}';
    }
}
