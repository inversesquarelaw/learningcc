public class Reverse{

    //have to use char[] or StringBuffer b/c java Strings are immutable
    //does it in in-place, with O(1) extra space
    private static void reverse(char[] str){

        /*
        str = "something something".toCharArray();
        */

        int start, end;
        char tmp;

        start = end = 0;

        if( str != null ){
            while( end < str.length ){
                ++end;
            }
            --end;

            while( start < end ){
                tmp             = str[start];
                str[start++]    = str[end];
                str[end--]      = tmp;
            }
        }
    }

    private static String reverserecursive(String s){
        if( s.equals("")){          //base case is empty string
            return s;
        }

        return reverserecursive(s.substring(1)) + s.charAt(0);
    }

    public static void main(String args[]){
        char[] my_str = "Hello World".toCharArray();

        System.out.println(my_str);
        reverse(my_str);
        System.out.println(my_str);


        String str = "Hello World.";
        System.out.println("Before: " + str);
        String newStr = reverserecursive(str);
        System.out.println("After: " + newStr);
    }


}
