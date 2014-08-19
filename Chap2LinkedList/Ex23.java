/* ************************************************** *
 * Deleting a node in a singlely (no prev ptr) in a linked list given only access to that node
 * Not given reference to head node of linked list
 * ************************************************** */

public class Ex23{

    private static boolean deleteNode(Node curr){
        if( curr == null || curr.next == null ){
            return false;                       //failure
        }

        Node next = curr.next;
        curr.data = next.data;
        curr.next = next.next;

        return true;
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

        Node tmp = LL.appendToTail(1234567890);
        for(int i=0; i < 10; ++i){
            LL.appendToTail(i);
        }


        System.out.println("Original:");
        print(LL);

        System.out.println("Deleted Node 1234567890...");
        deleteNode(tmp);
        print(LL);

    }
}

