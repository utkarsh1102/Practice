package DataStructureAndAlgorithm.doublelinkedlist;

public class doublyLinkedLists {

    private Node head;
    private Node tail;
    private int lenght;

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public doublyLinkedLists(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        lenght = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (lenght == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            lenght++;
        }
    }

    // this is my code
//    public Node removeLast()
//    {
//        Node temp = tail;
//        if(lenght == 0)
//        {
//            return null;
//        }
//        tail = tail.prev;
//        tail.next=null;
//        temp.prev=null;
//        lenght--;
//        // this is the case when we only have one items in the linked list
//        if(lenght == 0)
//        {
//            head = null;
//            tail = null;
//        }
//        return temp;
//    }

    // this is sir code

    public Node removelast()
    {
        if(lenght == 0)
        {
            return null;
        }
        Node temp = tail;
        if(lenght == 1)
        {
            head = null;
            tail = null;
        }
        else
        {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        lenght--;
        return temp;
    }

    // this is my code
    public void prepent(int value)
    {
        Node newnode = new Node(value);
        if(lenght == 0)
        {
            head = newnode;
            tail = newnode;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
        lenght++;
    }

    // my method
    public Node removeFirst()
    {
        Node temp = head;
        if(lenght == 0)
        {
            return null;
        }
        if(lenght == 1)
        {
            head = null;
            tail = null;
        }
        head = head.next;
        head.prev=null;
        temp.next=null;
        lenght--;
        return temp;
    }

//    // this code is exactly same as the single linked list
//    // so we need to optimise the code.
//    public Node get(int index)
//    {
//        if (index < 0 || index >= lenght)
//        {
//            return null;
//        }
//        Node temp = head;
//        for(int i = 0; i < index; i++)
//        {
//            temp = temp.next;
//
//        }
//        return temp;
//    }

    // so let optimize the code
    public Node get(int index)
    {
        if(index < 0 || index >= lenght)
        {
            return null;
        }
        Node temp = head;
        if(index < lenght/2)
        {
            for(int i = 0; i < index; i++)
            {
                temp = temp.next;
            }

        }
        else {
            temp = tail;
            for(int i = lenght - 1; i> index;i--)
            {
                temp = temp.prev;
            }
        }
        return temp;
    }

    //if we want to set the value at the particular index then
    // we have to write the code for set.

    public boolean set(int index, int value)
    {
        Node temp = get(index);
        if(temp != null)
        {
            temp.value=value;
            return true;
        }
        return false;
    }

    // if we want to insert the element at the particular index then what we have to do.
    // ye tho hum ne he likh diya.
    public boolean insert(int index, int value)
    {
        Node newnode = new Node(value);
        if(index < 0 || index > lenght)
        {
            return false;
        }
        if(index == 0)
        {
            prepent(value);
            return true;
        }
        if(index == lenght-1)
        {
            append(value);
            return true;
        }
        Node pre = get(index-1);
        Node temp = pre.next;
        pre.next=newnode;
        newnode.prev = pre;
        temp.prev=newnode;
        newnode.next=temp;
        lenght++;
        return true;
    }

    //abb humko remove ka code likh ne hai

//    public Node removeitem(int index)
//    {
//        if(index < 0 || index >= lenght)
//        {
//            return null;
//        }
//        if(index == 0)
//        {
//            return removeFirst();
//        }
//        if(index == lenght - 1)
//        {
//            return removelast();
//        }
//        if(lenght == 1)
//        {
//            head = null;
//            tail = null;
//        }
//        Node temp = get(index);
//        Node before = temp.prev;
//        Node after = temp.next;
//        before.next=after;
//        after.prev=before;
//        temp.next=null;
//        temp.prev=null;
//        lenght--;
//        return temp;
//
//    }

    // Aur hum key ker sak the hai isme dek the hai,
    public Node removeitem(int index)
    {
        if(index < 0 || index >= lenght)
        {
            return null;
        }
        if(index == 0)
        {
            return removeFirst();
        }
        if(index == lenght - 1)
        {
            return removelast();
        }
        if(lenght == 1)
        {
            head = null;
            tail = null;
        }
        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;
        // after that we have to assign this with
        before.next=after;
        after.prev=before;

        // this can also be helpful but we have to implement this one.
        
       temp.next.prev = temp.prev;
       temp.prev.next = temp.next;
        temp.next=null;
        temp.prev=null;
        lenght--;
        return temp;

    }





    // just like linked list we have to create the 4 methods which are
    //by this we can print the list and get the head tail and the length of the linked list.


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + lenght);
    }


}
