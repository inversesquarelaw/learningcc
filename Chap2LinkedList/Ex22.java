/* ************************************************** *
 * Demos ways to find the kth to last element in a linked list
 * returns index of kth smallest element, where k == 1 is last element
 * ************************************************** */


public class Ex22{

    /* ************************************************** *
     * if length is known, then trivial. just length-k
     * O(n) run time, iterate over list until length-k elemnt is reached
     * O(1) extra space
     * ************************************************** */
    private static int kthToLast1(Node n, int k, int length){
        // b/c of the math, if index is 0, then error
        int i = 1;

        // need some code to output data just for me to self-check
        while( n != null && i <= length-k ){
            if( i == length-k ){
                System.out.println("kthToLast1 data: " + n.data);
            }

            //increment
            n = n.next;
            ++i;
        }
        return length - k;
    }

    /* ************************************************** *
     * recursive implementation.
     * recursively find the end of list. then return i=0, 1, 2, 3, ... until k == i
     * O(n) run time, O(n) extra space (recursion stack)
     * ************************************************** */
    private static int kthToLast2(Node n, int k){
        if( n == null ) return 0;

        int i = kthToLast2(n.next, k) + 1;

        if( i == k ){
            System.out.println("kthToLast2 data: " + n.data);
        }

        return i;
    }

    /* ************************************************** *
     * iterative solution: 2 ptrs ptr1 and ptr2, increment gap to be k wide, then iterate over list
     * until gap ptr points to end of list
     * O(n) run time, O(1) extra space
     * ************************************************** */
    private static int kthToLast3(Node n, int k){
        if( k<=0 ) return 0;

        int count = 0;
        Node ptr1 = n;
        Node ptr2 = n;

        //move ptr1 forward k nodes into the list
        for( int i=0; i < k; ++i ){
            if( ptr2 == null ) return 0;     //error check
            ptr2 = ptr2.next;
        }
        if( ptr2 == null ) return 0;         //eror check

        //now move ptr1 and ptr2 at the same rate, when ptr2 hits end, ptr1 will be at the right element.
        while( ptr2 != null ){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            ++count;
        }
        System.out.println("kthToLast3 data: " + ptr1.data);
        return count;
    }


    //helper function to print contents of linked list
    private static void print(Node n){
        while( n != null ){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    //helper to get length of a linked list
    private static int length(Node n){
        int i = 1;

        while( n != null) {
            ++i;
            n = n.next;
        }
        return i;
    }

    //tester/driver main
    public static void main(String args[]){

        int k = 1;
        int kthIndex = 0;

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

        kthIndex = kthToLast1(LL, 1, length(LL));
        System.out.println("kthToLast1 Index: " + kthIndex);

        kthIndex = kthToLast2(LL, 1);
        System.out.println("kthToLast2 Index: " + kthIndex);

        kthIndex = kthToLast3(LL, 1);
        System.out.println("kthToLast3 Index: " + kthIndex);
        System.out.println();

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

        kthIndex = kthToLast1(LL, 1, length(LL));
        System.out.println("kthToLast1 Index: " + kthIndex);

        kthIndex = kthToLast2(LL, 1);
        System.out.println("kthToLast2 Index: " + kthIndex);

        kthIndex = kthToLast3(LL, 1);
        System.out.println("kthToLast3 Index: " + kthIndex);
        System.out.println();

        //test 3 null corner case
        LL = null;

        System.out.println("Original:");
        print(LL);

        kthIndex = kthToLast1(LL, 1, length(LL));
        System.out.println("kthToLast1 Index: " + kthIndex);

        kthIndex = kthToLast2(LL, 1);
        System.out.println("kthToLast2 Index: " + kthIndex);

        kthIndex = kthToLast3(LL, 1);
        System.out.println("kthToLast3 Index: " + kthIndex);
        System.out.println();

    }

}
