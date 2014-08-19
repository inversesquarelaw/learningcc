/*
Demos how to remove duplicates from an array.

Ex 1.3
*/
import java.util.ArrayList;

public class Ex13{

    //source: http://stackoverflow.com/a/5256930
    private static void removeDup2(StringBuffer arr){
        if( arr == null ) return;
        int len = arr.length();
        if( len < 2 ) return;

        // fist character will never be duplicate.
        // tail is the index of the next unique character.
        // like in qsort where lo, hi, lt, gt are boundry markers.
        int tail = 1;

        // cur iterates across all the char in str (from 1 to end of string)
        for( int cur=1; cur < len; ++cur ){
            int j;
            //j iteratres across the unique chars found so far (from 0 to tail )

            // is char at index i already in my list of uniq char?
            for( j=0; j < tail; ++j ){
                if( arr.charAt(cur) == arr.charAt(j) ){
                    break;
                }
            }


            // if no then add it to my uniq char list.
            if( j == tail ){
                arr.setCharAt(tail, arr.charAt(cur));
                // it only copies when there is no dup.
                // i.e. it found a new unique char 
                //copying cur to tail even though no dup. it ALWAYS copies. except when there is a dup. b/c if there is a dup, j will never == tail.

                // increment tail as we just added a new elmt.
                // WORKS SORT OF LIKE QSORT, where you have i and j as 
                // markers/pointers to where to boundry is.
                ++tail;
            }
        }
        // at this point the characters from index [0,tail] are unique
        // if there were any duplicates they are between [tail,input.length]
        // so truncate the length of input to tail.
        arr.setLength(tail);
    }

    // function takes a char array as input.
    // modifies it to remove duplicates and adds a 0 to mark the end
    // of the unique chars in the array.
    //source: http://stackoverflow.com/questions/2598129/function-to-remove-duplicate-characters-in-a-string
    private static void removeDup(char[] str) {
        if (str == null) return; 

        int len = str.length; 
        if (len < 2) return; 
        // if its less than 2..can't have duplicates..return.

        int tail = 1; 
        // number of unique char in the array.

        //start at 2nd char and go till the end of the array.
        for (int i = 1; i < len; ++i) { 
            int j;

            // for every char in outer loop check if that char is already seen.
            // char in [0,tail]}} are all unique.
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break; // break if we find duplicate.
            }
            // if j reachs tail..we did not break, which implies this char at pos i
            // is not a duplicate. So we need to add it our "unique char list"
            // we add it to the end, that is at pos tail.
            if (j == tail) {
                str[tail] = str[i]; // add
                ++tail; // increment tail...[0,tail]} is still "unique char list"
            }
        }

        //this is much better than below. this is how you c-style "null-terminate" a string in java

        for(; tail < len;tail++){
            str[tail] = 0; 
            // add a 0 at the end to mark the end of the unique char.
        }
        //this "^@" character is the "null" char. You can only see it on vim, null chars don't display on the console.
        //but since java strings/char[] aren't null terminated, they don't "end"/"stop" when then see the null char.
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
        char [] string1 = "the cat in the hat like to eat cats".toCharArray();

        //different test cases: no duplicates, all duplicates, null string, continous duplicates, non-cont dups, empty str.
        char [] string2 = "abcd".toCharArray();
        char [] string3 = "aaaa".toCharArray();
        char [] string4 = null;
        char [] string5 = "aaaabbb".toCharArray();
        char [] string6 = "abababab".toCharArray();
        char [] string7 = "".toCharArray();

        System.out.println("Using String/char[]");
        my_print("Before: ", string1);
        removeDup(string1);
        my_print("After: ", string1);

        my_print("Before: ", string2);
        //need the for loop to wrap around str[tail] = 0, otherwise when there
        //no duplicates in the string, it will cause array out of bounds.
        removeDup(string2);
        my_print("After: ", string2);

        my_print("Before: ", string3);
        removeDup(string3);
        my_print("After: ", string3);

        my_print("Before: ", string4);
        removeDup(string4);
        my_print("After: ", string4);

        my_print("Before: ", string5);
        removeDup(string5);
        my_print("After: ", string5);

        my_print("Before: ", string6);
        removeDup(string6);
        my_print("After: ", string6);

        my_print("Before: ", string7);
        removeDup(string7);
        my_print("After: ", string7);



        //data is different than string data, in that you don't have to resize the array after removing duplicates

        //test cases
        StringBuffer buf1 = new StringBuffer("abcdefg"); //no dups
        StringBuffer buf2 = new StringBuffer("aaaaaaa"); //all dups
        StringBuffer buf3 = null;                        //null array 
        StringBuffer buf4 = new StringBuffer("");        //empty array 
        StringBuffer buf5 = new StringBuffer("aaaabbbccddd"); //continous dups 
        StringBuffer buf6 = new StringBuffer("adbabbccadad"); //continous dups 

        System.out.println("Using StringBuffer");
        System.out.println("buf1");
        System.out.println("Before: "+ buf1.toString());
        removeDup2(buf1);
        System.out.println("After: "+ buf1.toString());
        System.out.println("");

        System.out.println("buf2");
        System.out.println("Before: "+ buf2.toString());
        removeDup2(buf2);
        System.out.println("After: "+ buf2.toString());
        System.out.println("");

        System.out.println("buf3: null");
        System.out.println("null");
        System.out.println("");

        System.out.println("buf4: empty");
        System.out.println("Before: "+ buf4.toString());
        removeDup2(buf4);
        System.out.println("After: "+ buf4.toString());
        System.out.println("");

        System.out.println("buf5");
        System.out.println("Before: "+ buf5.toString());
        removeDup2(buf5);
        System.out.println("After: "+ buf5.toString());
        System.out.println("");

        System.out.println("buf6");
        System.out.println("Before: "+ buf6.toString());
        removeDup2(buf6);
        System.out.println("After: "+ buf6.toString());
        System.out.println("");

        StringBuffer buf7 = new StringBuffer("abcefghi");//visualize how func works
        System.out.println("Before: "+ buf7.toString());
        removeDup2(buf7);
        System.out.println("After: "+ buf7.toString());
        System.out.println("");
    }


}

