package org.learning.collection.list.linked_list.doubly_linked_list;

import org.learning.collection.list.linked_list.LinkedList;

public class DoublyLinkedList<E> extends LinkedList<E> {
    @Override
    public void add(E data) {
        Node<E> node = new Node<>(data);
        if(head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;

    }

    @Override
    public void addFirst(E data) {
        Node<E> node = new Node<>(data);
        if(head == null){
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void addAtIndex(E data, int index) {
        if(index == 0) addFirst(data);
        else if (index == size) add(data);
        else {
            if(index < 0 || index < size){
                System.out.println("Index out of bound");
                return;
            }
            Node<E> currentNode = head;
            Node<E> node = new Node<>(data);
            for(int i=0; i<index ; i++){
               currentNode = currentNode.next;
            }
            node.next = currentNode.next;
            currentNode.next.prev = node;

            currentNode.next = node;
            node.prev = currentNode;
            size++;
        }

    }

    @Override
    public void remove() {
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    @Override
    public void removeFirst() {
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    @Override
    public void removeAtIndex(int index) {
        if(index == 0) removeFirst();
        else if(index == size) remove();
        else {
            if(index < 0 || index < size){
                System.out.println("Index out of bound");
                return;
            }
            Node<E> currentNode = head;
            for(int i=0; i<index ; i++){
                currentNode = currentNode.next;
            }
            currentNode.next =  currentNode.next.next;
            currentNode.next.prev = currentNode;
        }
    }
}
