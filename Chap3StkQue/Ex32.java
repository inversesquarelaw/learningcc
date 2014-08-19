/*  Implement a Queue data structure with 2 Stacks
 *
 */

import java.util.*;

class Ex32{

    /*
     * my own queue implementation using 2 stacks: in and out.
     * in is used to ENQUEUE.
     * out is used to DEQUEUE.
     * when out is empty, we pop all items from in and push onto out. this also reverses the order of how the items come in. changing from FILO to FIFO.
     *
     * code source: http://stackoverflow.com/a/69436
     *
     *
     * MyQueue:
     * O(1) for enqueuing.
     * O(n) for dequeuing.
     * vs.
     * O(1) for both enqueue and dequeue in a Queue.
     *
     */
    static class MyQueue<Item>{
        private Stack<Item> in;
        private Stack<Item> out;

        public MyQueue(){
            in  = new Stack<>();
            out = new Stack<>();
        }

        //O(1) for enqueue() operation,
        //but O(n) for dequeue() if "in" is not empty.
        public void enqueue(Item item){
            in.push(item);
        }

        //O(n) for dequeue() since we have to traverse through "in" popping
        //and push onto out.
        public Item dequeue(){
            if(out.isEmpty()){
                while(!in.isEmpty()){
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public int size(){
            return in.size() + out.size();
        }

        public boolean isEmpty(){
            return this.size() == 0;
        }
    }

    /*
     * Driver to test MyQueue with standard collections Queue to check that
     * they're behavior is consistent.
     *
     */
    public static void main(String args[]){
        MyQueue<Integer> myQ = new MyQueue<>();
        Queue<Integer> Q = new Queue<>();

        for(int i=0; i<10; ++i){
            myQ.enqueue(i);
            Q.enqueue(i);
        }

        System.out.println("Dequeueing.");
        for(int i=0; i<5; ++i){
            System.out.println("Item: " + Q.peek() +  ", myQ same as Q: " + myQ.dequeue().equals(Q.dequeue()));
        }

        for(int i=100; i<110; ++i){
            myQ.enqueue(i);
            Q.enqueue(i);
        }

        System.out.println("Dequeueing.");
        while( !Q.isEmpty() || !myQ.isEmpty() ){
            System.out.println("Item: " + Q.peek() +  ", myQ same as Q: " + myQ.dequeue().equals(Q.dequeue()));
        }

        for(int i=200; i<210; ++i){
            myQ.enqueue(i);
            Q.enqueue(i);
        }

        System.out.println("Dequeueing.");
        for(int i=0; i<3; ++i){
            System.out.println("Item: " + Q.peek() +  ", myQ same as Q: " + myQ.dequeue().equals(Q.dequeue()));
        }

        for(int i=300; i<310; ++i){
            myQ.enqueue(i);
            Q.enqueue(i);
        }

        System.out.println("Dequeueing.");
        for(int i=0; i<3; ++i){
            System.out.println("Item: " + Q.peek() +  ", myQ same as Q: " + myQ.dequeue().equals(Q.dequeue()));
        }

        System.out.println("Dequeueing.");
        while( !Q.isEmpty() || !myQ.isEmpty() ){
            System.out.println("Item: " + Q.peek() +  ", myQ same as Q: " + myQ.dequeue().equals(Q.dequeue()));
        }

    }

}
