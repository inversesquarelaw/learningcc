/*
 * LinkedList (like in LinkedList.java) using Generics.
 *
 */

public class LinkedListGenerics<Integer>{
    private Node<Integer> head = null;

    private class Node<Integer>{
        private String data;
        private Node next;

        public Node<Integer>(Integer d){
            data = d;
        }
    }

    public void appendToTail(Integer d){
        Node<Integer> newTail = new Node<>(d);
        Node curr = head;

        while(curr.next ! = null ){
            curr = curr.next;
        }
    }

}
