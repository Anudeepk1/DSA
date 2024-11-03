package org.learning.linked_lists.doubly_linked_list;


import org.learning.linked_lists.AbstractList;

import java.util.Scanner;
class Node{
    Integer value;
    Node prev;
    Node next;
}

class DLL extends AbstractList {
    @Override
    public void size() {
    }

    @Override
    public void add(int val) {

    }

    @Override
    public void addFirst(int val) {

    }

    @Override
    public void addAtIndex(int val, int index) {

    }
    @Override
    public void printList() {

    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void remove() {

    }

    @Override
    public void removeAtIndex(int index) {

    }

    @Override
    public void removeFirst() {

    }
    @Override
    public void clear() {

    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        {
            Scanner sc = null;
            Integer operation;
            int val;
            int index;

            do {
                System.out.println("Singly Linked List\n" +
                        "1. add\n" +
                        "2. PrintList\n" +
                        "3. addFirst\n" +
                        "4. addAtIndex\n" +
                        "5. remove\n" +
                        "6. removeFirst\n" +
                        "7. removeAtIndex\n" +
                        "8. get\n" +
                        "9. getFirst\n" +
                        "10. getLast\n" +
                        "11. contains\n" +
                        "12. indexOf\n" +
                        "13. size\n" +
                        "14. isEmpty\n" +
                        "15. clear\n" +
                        "16. reverse\n" +
                        "17. findMiddle\n" +
                        "18. sort\n" +
                        "19. exit");
                sc = new Scanner(System.in);
                operation = sc.nextInt();

//                switch (operation){
//                    case 1: //add
//                        System.out.print("Add new node: ");
//                        val = sc.nextInt();
//                        linkedList.add(val);
//                        break;
//
//                    case 2:
//                        linkedList.printList();
//                        break;
//
//                    case 3:
//                        System.out.println("Add new node At First: ");
//                        val = sc.nextInt();
//                        linkedList.addFirst(val);
//                        break;
//                    case 4:
//                        System.out.println("Add new node at Index: ");
//                        val = sc.nextInt();
//                        index = sc.nextInt();
//                        linkedList.addAtIndex(val, index);
//                        break;
//                    case 5:
//                        System.out.println("Remove element from list");
//                        linkedList.remove();
//                        linkedList.printList();
//                        break;
//                    case 6:
//                        System.out.println("Remove First element from the list");
//                        linkedList.removeFirst();
//                        linkedList.printList();
//                    case 7:
//                        System.out.println("Remove Element at Index from the list");
//                        index = sc.nextInt();
//                        linkedList.removeAtIndex(index);
//                        linkedList.printList();
//                    case 13:
//                        System.out.println("Get List size");
//                        linkedList.size();
//                        break;
//                    case 14:
//                        boolean isEmpty = linkedList.isEmpty();
//                        System.out.println(isEmpty);
//                        break;
//                    case 15:
//                        linkedList.clear();
//                        break;


//                }
            } while (!operation.equals(19) && operation<19);
        }
    }
}
