/*

refer to PassingJavaReferences to see why you can't swap values as easliy as you can in C.

*/
class Ex12{
    
    private static void reverse(char[] str){
        //The resaon this works, unlike PassingJavaReferences.java, is because you are modifying the elements of the array. NOT the reference (the array) itself.
        /*
        //like this:
        str = new char[1];
        str[0] = 'a';
        */

        if( str != null ) {

            int start, end;
            char tmp;

            start = end = 0;

            while( end < str.length ){
                ++end;
            }
            --end;

            while(start < end){
                tmp = str[start];
                str[start++] = str[end];
                str[end--] = tmp;
            }
        }
    }//end reverse()

    public static void main(String[] args){
        String my_str = "Hello World.";
        char[] str_to_chararray = my_str.toCharArray();
        //Java strings are NOT null terminated like C-strings

        System.out.println("before: ");
        for( char letter: str_to_chararray ){
            System.out.printf("%s", letter);
        }

        reverse(str_to_chararray);

        System.out.println("\nafter: ");
        for( char letter: str_to_chararray ){
            System.out.printf("%s", letter);
        }
    }//end main()

}
