package cz.cvut.mk.model;

public interface Observable<T> {

    void addFriend(User user);

    void notifyFriends(T data);
}
