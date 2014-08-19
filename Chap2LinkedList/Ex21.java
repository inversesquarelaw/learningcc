/*
 * 2 different ways to remove duplicate nodes in a linked list.
 *
 */

import java.util.Hashtable;

public class Ex21{

    private static class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
        }

        public void appendToTail(int d){
            Node newTail = new Node(d);
            Node head = this;

            while( head.next != null ){
                head = head.next;
            }
            head.next = newTail;
        }
    }

    private static void delDups1(Node n){
        Hashtable<Integer, Boolean> ht = new Hashtable<>();
        Node prev = null;

        while( n != null ){
            if( ht.containsKey(n.data) ){
                prev.next = n.next;
            } else {
                ht.put(n.data, true);
                prev = n;
            }
            n = n.next;
        }
    }   //end delDups1

    private static void delDups2(Node n){

        while( n != null ){
            Node runner = n;
            while( runner.next != null ){
                if( runner.next.data == n.data ){
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
    }

    //helper function to print contents of linked list
    private static void print(Node n){
        while( n != null ){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        Node LL = new Node(0);
        for(int i=0; i < 10; ++i){
            LL.appendToTail(i);
            LL.appendToTail(i);
        }
        for(int i=0; i < 10; ++i){
            LL.appendToTail(i);
        }


        System.out.println("Original:");
        print(LL);

        delDups1(LL);

        System.out.println("Remove Dups:");
        print(LL);

        //prep for 2nd test
        for(int i=0; i < 10; ++i){
            LL.appendToTail(i);
            LL.appendToTail(i);
        }
        for(int i=0; i < 10; ++i){
            LL.appendToTail(i);
        }

        System.out.println("Original:");
        print(LL);

        delDups2(LL);

        System.out.println("Remove Dups:");
        print(LL);

        //test 3 null corner case
        LL = null;

        System.out.println("Original:");
        print(LL);

        delDups2(LL);

        System.out.println("Remove Dups:");
        print(LL);

    }
}
