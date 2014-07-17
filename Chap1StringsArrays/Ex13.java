/*
Demos how to remove duplicates from an array.

Ex 1.3
*/

public class Ex13{

    private static void removeDup(char[] str){
        if (str == null) return;
        int len = str.length;
        if(len < 2) return;

        int tail = 1;
        for(int i=1; i < len; ++i){

            int j;
            for(j=0; j < tail; ++j){
                if( str[i] == str[j] ) break;
            }
            if (j == tail){
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;      //tries to null terminate new end point
    }
    
    private static void my_print(String context, char[] str){
        //this "^@" character is the "null" char.
        //but since java strings/char[] aren't null terminated, they don't "end"/"stop" when then see the null char.
        if (str == null)                return;
        System.out.println(context);
        for( char letter: str){
            System.out.printf("%s", letter);
        }
        System.out.println("");

        if( context.equals("After: ") ){
            System.out.println("");
        }
    }


    public static void main(String args[]){
        char [] data1 = "the cat in the hat like to eat cats".toCharArray();
        
        //different test cases: no duplicates, all duplicates, null string, continous duplicates, non-cont dups, empty str.
        char [] data2 = "abcd".toCharArray();
        char [] data3 = "aaaa".toCharArray();
        char [] data4 = null;
        char [] data5 = "aaaabbb".toCharArray();
        char [] data6 = "abababab".toCharArray();
        char [] data7 = "".toCharArray();

        my_print("Before: ", data1);
        removeDup(data1);
        my_print("After: ", data1);

        my_print("Before: ", data3);
        removeDup(data3);
        my_print("After: ", data3);

        my_print("Before: ", data4);
        removeDup(data4);
        my_print("After: ", data4);

        my_print("Before: ", data5);
        removeDup(data5);
        my_print("After: ", data5);

        my_print("Before: ", data6);
        removeDup(data6);
        my_print("After: ", data6);

        my_print("Before: ", data7);
        removeDup(data7);
        my_print("After: ", data7);

    }


}

