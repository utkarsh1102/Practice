package DataStructureAndAlgorithm.Linked_List;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


    // this is the node class used for creating the node.
    // and this is the inside of the linked list class
    // it is a nested class.
    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public String append(int value) {
        //phela hum node baneyenga
        Node newNode = new Node(value);
        //then hum length chack kera ge
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
        return "Items is added in the linked list";
    }

    public Node removelast() {
        Node temp = head;
        Node pre = head;
        if (length == 0) {
            return null;
        }
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }


    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

//    // this is mine
//    public Node removeFirst()
//    {
//        Node temp = head;
//        Node pre = head;
//        if(length == 0)
//        {
//            return null;
//        }
//        else
//        {
//            head=temp.next;
//            pre.next=null;
//        }
//        length--;
//        if(length == 0)
//        {
//            head = null;
//            tail = null;
//        }
//        return pre;
//
//    }

    // ye vala sir ke hai
    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }

        return temp;
    }


    // if we want to get the number at the particular index
    // is get method se humko sirf value mile ge but aage hum isko remove bhi kera ge.
    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return temp;
    }

    // for set the item at the particular index.


    // this code is mine and not working
    // ye me insert ke code likh raha the
//    public boolean setmethod(int index, int value)
//    {
//        Node newNode = new Node(value);
//        if(length == 0)
//        {
//            head = newNode;
//            tail = newNode;
//        }
//        Node pre = head;
//        Node temp = head;
//        for(int i  = 0; i< index; i++)
//        {
//            temp.next=temp;
//            pre = temp;
//        }
//        pre.next = newNode;
//        newNode.next=temp;
//        length++;
//        return true;
//    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // this is my method
//    public boolean insert(int index, int value) {
//        Node newNode = new Node(value);
//        Node temp = head;
//        if (length == 0) {
//            head = newNode;
//            tail = newNode;
//        }
//        for (int i = 0; i < index; i++) {
//            temp.next = temp;
//        }
//        newNode.next = temp.next;
//        temp.next = newNode;
//        return true;
//    }

    // ye sir ke method hai.
    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }
        // what can we do if we insert something inbetween.
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node removeAtIndex(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0)
            removeFirst();

        if (index == length - 1)
            removelast();

        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    // if we want to reverse the linked list.

    public void reverse()
    {
        Node temp = head;

        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++)
        {
            after = temp.next;
            temp.next=before;
            before=temp;
            temp=after;
        }
    }


    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
