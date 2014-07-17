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
        //but since java strings/char[] aren't null terminated, they don't "end"/"stop" when then see the ull char.
        System.out.println(context);
        for( char letter: str){
            System.out.printf("%s", letter);
        }
        System.out.println("");
    }


    public static void main(String args[]){
        char [] data = "the cat in the hat like to eat cats".toCharArray();

        my_print("Before: ", data);
        removeDup(data);
        my_print("Before: ", data);
    }


}

