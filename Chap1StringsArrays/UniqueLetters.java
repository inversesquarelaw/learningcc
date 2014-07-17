/*
Demos a function that checks if a string contains only unique letters.

Multiple ways to solve this problem:
1) radix/bucket sort - O(n) running time, O(character set) space
2) bitvector - use a bitvector in place of a radix/bucket array
               O(n) running time, but O(1) extra space (use 1 variable as bit vector)
3) sorting - if you can destroy the ordering of the input/string
             O(n lg n) running time, space depends on which sort

4) brute force using 2 for loops - O(n^2) running time, no extra space.

*/
import java.util.Arrays;

public class UniqueLetters{

    private static boolean isUniqueLettersRadix(String str){
        boolean[] char_set = new boolean[256]; //assume ASCII char set (which is 256 chars)
        //arrays are auto initialized to 0's b/c of the new keyword (constructor)


        for(int i=0; i < str.length(); i++){
            int val = str.charAt(i);
            if( char_set[val] )             return false;
            else                            char_set[val] = true;
        }
        return true;
    }

    private static boolean isUniqueLettersBitvector(String str){
        int bitvector = 0;      
        //ints are 8 bytes => 32 bits. using each bit as a flag/marker to see if it has seen a specific letter before. 1 is seen, 0 is not seen.

        for( int i=0; i < str.length() ; i++ ){
            int val = str.charAt(i) - 'a';  
            //only consider 26 letters a to z b/c int primative type only has 32 bits to work with

            if( (bitvector & (1 << val)) > 0 )      return false;
            else                                    bitvector |= (1 << val);
        }
        return true;
    }

    private static boolean isUniqueLettersSort(String str){
        char[] data = str.toCharArray();
        Arrays.sort(data);
        
        for(int i=0; i < data.length-1 ; ++i ){
            if( data[i] == data[i+1] ) return false;
        }
        return true;
    }

    private static boolean isUniqueLettersBrute(String str){
        char[] data = str.toCharArray();

        for(int i=0; i < data.length ; ++i){
            for(int j=i+1; j < data.length ; ++j){
                if( data[i] == data[j] )      return false;
            }
        }
        return true;
    }



    public static void main(String args[]){
        long start, end, time_radix, time_bitvector, time_sort, time_brute;

        String duplicates = "abcdefghijklmnopqrstuvwxyaz";
        String no_duplicates = "abcdefghijklmnopqrstuvwxyz";

        start = System.nanoTime();
        System.out.printf("\n%s is unique radix: %s\n", duplicates, isUniqueLettersRadix(duplicates));
        System.out.printf("%s is unique radix: %s\n", no_duplicates, isUniqueLettersRadix(no_duplicates));
        end = System.nanoTime();
        time_radix = end - start;
        System.out.printf("radix time:\t\t%d ns\n", time_radix);

        start = System.nanoTime();
        System.out.printf("\n%s is unique bitvector: %s\n", duplicates, isUniqueLettersBitvector(duplicates));
        System.out.printf("%s is unique bitvector: %s\n", no_duplicates, isUniqueLettersBitvector(no_duplicates));
        end = System.nanoTime();
        time_bitvector = end - start;
        System.out.printf("bitvector time:\t\t%d ns\n", time_bitvector);

        System.out.printf("\nradix/bitvector:\t\t%5f\n", (double)time_radix/time_bitvector);

        start = System.nanoTime();
        System.out.printf("\n%s is unique sort: %s\n", duplicates, isUniqueLettersSort(duplicates));
        System.out.printf("%s is unique sort: %s\n", no_duplicates, isUniqueLettersSort(no_duplicates));
        end = System.nanoTime();
        time_sort = end - start;
        System.out.printf("sort time:\t\t%d ns\n", time_sort);

        System.out.printf("\nsort/bitvector:\t\t%5f\n", (double)time_sort/time_bitvector);

        start = System.nanoTime();
        System.out.printf("\n%s is unique brute: %s\n", duplicates, isUniqueLettersBrute(duplicates));
        System.out.printf("%s is unique brute: %s\n", no_duplicates, isUniqueLettersBrute(no_duplicates));
        end = System.nanoTime();
        time_brute = end - start;
        System.out.printf("brute time:\t\t%d ns\n", time_brute);

        System.out.printf("\nbrute/bitvector:\t\t%5f\n", (double)time_brute/time_bitvector);
    }
}

