package DataStructureAndAlgorithm.Queue;

public class Queue {

    class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.next = null;
            this.value = value;
        }
    }
    private Node front;
    private Node back;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        front = newNode;
        back = newNode;
        length++;
    }

    // This function is for the enqueue.
    public void Enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            front = newNode;
            back = newNode;
        }
        back.next=newNode;
        back=newNode;
        length++;
    }

    public Node dequeu()
    {
        Node temp = front;
        if(length == 0)
        {
            return null;
        }
        if(length == 1)
        {
            front=null;
            back = null;
        }
        front = front.next;
        temp.next=null;
        length--;
        return temp;
    }

    public void printQueue()
    {
        Node temp = front;
        if(temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getfront()
    {
        System.out.println("Front: " + front.value);
    }

    public void getback()
    {
        System.out.println("Back: " + back.value);
    }

    public void getlength()
    {
        System.out.println("Length: " + length);
    }

}
