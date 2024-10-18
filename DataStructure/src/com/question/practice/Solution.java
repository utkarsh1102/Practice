package com.question.practice;

import java.io.*;
import java.util.*;

class LinkedList{
    private Node head;
    private Node tail;
    private int length;

    class Node{
        private int value;
        private Node next;

        public Node(int value)
        {
            this.value = value;
            this.next=null;
        }
    }

    // public LinkedList(int value)
    // {
    //     Node newNode = new Node(value);
    //     head = newNode;
    //     tail = newNode;
    //     length++;
    // }

    public void add(int value)
    {
        Node newnode = new Node(value);
        if(length == 0)
        {
            head = newnode;
        }
        else{
            tail.next=newnode;
            tail=newnode;
            length++;
        }
    }

    public void printLinkedList()
    {
        Node temp = head;
        if(head == null)
        {
            System.out.println("Null");
        }
        else
        {
            while(temp !=  null)
            {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
    }

}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        LinkedList a = new LinkedList();
        a.add(5);
        a.add(45);
        a.add(4949);
        a.add(value);
        a.printLinkedList();

    }
}