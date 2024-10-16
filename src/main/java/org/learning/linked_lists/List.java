package org.learning.linked_lists;

public interface List {

    public void size();

    public void printList();

    public boolean isEmpty();

    public void add(int val);
    public void addFirst(int val);
    public void addAtIndex(int val, int index);

    public void remove();
    public void removeAtIndex(int index);
    public  void removeFirst();

    public void clear();



}
