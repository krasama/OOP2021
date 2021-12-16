package cz.cvut.mk.model;

public interface Observer<T> {

    void onMessage(T message);

}
