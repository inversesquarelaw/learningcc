public class Reverse{

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

    public static void main(String args[]){
        char[] my_str = "Hello World".toCharArray();

        System.out.println(my_str);
        reverse(my_str);
        System.out.println(my_str);
    }


}
