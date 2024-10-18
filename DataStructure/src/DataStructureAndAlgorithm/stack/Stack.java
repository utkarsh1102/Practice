package DataStructureAndAlgorithm.stack;

public class Stack {
    class Node
    {
        int value;
        Node next;

        public Node(int value)
        {
            this.value=value;
        }
    }

    private Node top;
    private int height;

    public Stack(int value)
    {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack()
    {
        Node temp = top;
        while(temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void push(int value)
    {
        Node newNode = new Node(value);
        if(height == 0)
        {
            top = newNode;
        }
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop()
    {
        Node temp = top;
        if(height == 0)
        {
            return null;
        }
        if(height == 1)
        {
            top = null;
        }
        top = top.next;
        temp.next=null;
        height--;
        return temp;
    }

    public void getTop()
    {
        System.out.println("Top: " + top.value);
    }

    public void getHeight()
    {
        System.out.println("Height: " + height);
    }




}
