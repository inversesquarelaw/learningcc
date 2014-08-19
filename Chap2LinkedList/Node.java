/*
 * Basic quick and dirty linked list implementation.
 *
 * Even though the name of the file is Node.java it is a LL implementation.
 * No Encapsulation or Abstraction or OOP.
 *
 * With a constructor and append method.
 *
 */
public class Node{
    Node next = null;
    int data;

    //contructor
    public Node(int d){
        data = d;
    }

    //adding to list
    public Node appendToTail(int d){
        Node newLast = new Node(d);
        Node n = this;                  //don't need head variable

        while(n.next != null){
            n = n.next;
        }
        n.next = newLast;
        return newLast;
    }

    //driver/tester
    public static void main(String args[]){
        Node linkedlist = new Node(100); //no more default constr

        for(int i=101; i<110; ++i){
            linkedlist.appendToTail(i);
        }

        while(linkedlist != null ){
            System.out.println(linkedlist.data);
            linkedlist = linkedlist.next;
        }
    }
}
