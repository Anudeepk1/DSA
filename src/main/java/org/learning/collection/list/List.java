package org.learning.collection.list;

import org.learning.collection.Collection;

import java.util.Arrays;

public interface List<E> extends Collection<E> {
    void get(int index);
    void set(E data, int index);
    void add(E data);
    void addFirst(E data);
    void addAtIndex(E data, int index);
    void remove();
    void removeFirst();
    void removeAtIndex(int index);
    void print();
    void subList(int fromIndex, int toIndex);


}

