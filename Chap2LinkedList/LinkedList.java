/*
 * A better LinkedList implementation based on Node.java
 * This one is more "abstraction" and "ecapsulated" and "OOP"
 */

public class LinkedList{
    Node head = null;

    private class Node{
        private int data;
        private Node next;

        public Node(int d){
            data = d;
        }
    }

    public void appendToTail(int d){
        Node newTail = new Node(d);

        if( head == null ){
            head = newTail;
        }
        else {
            Node curr = head;

            while( curr.next != null ){
                curr = curr.next;
            }
            curr.next = newTail;

        }
    }

    //driver/tester
    public static void main(String args[]){
        LinkedList LL = new LinkedList(); //no more default constr

        for(int i=101; i<110; ++i){
            LL.appendToTail(i);
        }

        Node curr = LL.head;
        while(curr != null ){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
