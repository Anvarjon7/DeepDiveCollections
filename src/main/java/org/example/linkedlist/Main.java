package org.example.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.append(10);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.prepend(7);
        myLinkedList.append(7);

        System.out.println("deleted dups: ");
        myLinkedList.deleteDuplicates();
        myLinkedList.printList();

//
//        System.out.println("current list: ");
//        myLinkedList.printList();
//
//        myLinkedList.delete(5);
//        System.out.println("after deleting 5: ");
//        myLinkedList.printList();
//
//        System.out.println("after deleting head 7: ");
//        myLinkedList.printList();
    }
}
