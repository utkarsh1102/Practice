package DataStructureAndAlgorithm.binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }


    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value)
                return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

//    //this is mine
//    public boolean contains(int value) {
//        if (root == null) {
//            return false;
//        }
//        Node temp = root;
//        while (temp != null) {
//            if (temp.value == value) {
//                return true;
//            } else {
//                if (temp.value < value) {
//                    temp = temp.left;
//                } else {
//                    temp = temp.right;
//                }
//            }
//        }
//        return false;
//    }

    public boolean contains(int value) {
        if (root == null)
            return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value)
    {
        if(currentNode == null)
            return false;

        if(currentNode.value == value)
            return true;

        if(value < currentNode.value)
        {
            return rContains(currentNode.left, value);
        }
        else {
            return rContains(currentNode.right , value);
        }
    }


    public boolean rContains(int value)
    {
        return rContains(root, value);
    }


    public int minValue(Node currentNode)
    {
        while(currentNode.left != null)
        {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

     private Node deleteNode(Node currentNode, int value)
     {
         if(currentNode == null)
         {
             return null;
         }
         if (currentNode.value < value)
         {
             currentNode.right = deleteNode(currentNode.right, value);
         }
         else if (value < currentNode.value) {
             currentNode.left = deleteNode(currentNode.left, value);
         }
         else {
             // ye vala theeno node ko remove ker de ga
//             first leaf ko
//                     second left child vale ko
//                     third right child vale ko
                if(currentNode.left == null && currentNode.right == null)
                {
                    return null;
                }
                else if (currentNode.left == null)
                {
                    currentNode = currentNode.right;
                }
                else if (currentNode.right == null)
                {
                    currentNode = currentNode.left;
                }
                // iss code se hum delete kera ge uss node ko jiske pass two node hai
                else {
                    int subTreeMin = minValue(currentNode.right);
                    currentNode.value = subTreeMin;
                    currentNode.right = deleteNode(currentNode.right, subTreeMin)
                    ;
                }
         }
         return currentNode;
     }


     public void deleteNode(int value)
     {
         deleteNode(root, value);
     }


     public ArrayList<Integer> BFS()
     {
         // ye he simple move kera ge tree me
         Node currentNode = root;
         // phela hum ne decare ker liye
         Queue<Node> queue = new LinkedList<>();
         ArrayList<Integer> results = new ArrayList<>();
         queue.add(currentNode);
         while (queue.size() > 0)
         {
             currentNode = queue.remove();
             results.add(currentNode.value);
             if(currentNode.left != null)
             {
                 queue.add(currentNode.left);
             }
             if(currentNode.right != null)
             {
                 queue.add(currentNode.right);
             }
         }
         return results;
     }

     public ArrayList<Integer> DFSPreOrder() {
         ArrayList<Integer> results = new ArrayList<>();

         class Traverse {
             Traverse(Node currentNode) {
                 results.add(currentNode.value);
                 if (currentNode.left != null) {
                     new Traverse(currentNode.left);
                 }
                 if (currentNode.right != null) {
                     new Traverse(currentNode.right);
                 }
             }
         }
         new Traverse(root);

         return results;
     }

     public ArrayList<Integer> DFSPostOrder()
     {
         ArrayList<Integer> results = new ArrayList<>();
         class Traverse{
             Traverse(Node currentNode)
             {
                  if(currentNode.left != null)
                  {
                      new Traverse(currentNode.left);
                  }
                  if(currentNode.right != null)
                  {
                      new Traverse(currentNode.right);
                  }
                  results.add(currentNode.value);
             }
         }

         new Traverse(root);

         return results;
     }

     public ArrayList<Integer> DFSInOrder()
     {
         ArrayList<Integer> results = new ArrayList<>();

         class Traverse{
             Traverse(Node currentNode)
             {
                 if(currentNode.left != null)
                 {
                     new Traverse(currentNode.left);
                 }
                 results.add(currentNode.value);
                 if(currentNode.right != null)
                 {
                     new Traverse(currentNode.right);
                 }
             }
         }
         new Traverse(root);

         return results;
     }
}
