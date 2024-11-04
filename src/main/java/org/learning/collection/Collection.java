package org.learning.collection;

public interface Collection<E> {
    void add(E value);
    void remove();
    boolean contains(E value);
    int size();
    boolean isEmpty();
    void clear();
    E[] toArray();

}
