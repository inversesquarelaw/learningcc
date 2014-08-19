/*
 * Demos different ways to solve anagram problem.
 * i.e. Is str1 an anagram/permuation of str2?
 * 
 * Solutions from CC:
 * 1)  Sort both strings and compare each index i, to see if they are the same.
 * 2)  Radix/bucket sort both strings, to see if they have the same count of chars.
 * Similar to hashing.
 * 
 * Solutions from Interactive Python:
 * 1)  Check off:          O(n^2)
 * - 2 for loops, checking if each char in s1 is in s2
 * 
 * 2)  Sort and compare:   O(n lg n)
 * - sort s1 and s2 and see if the sorted results are the same
 * 
 * 3)  Brute force:        O(2^n)
 * - generate a set of all possible string using chars from s1 and see if s2 in in that set.
 * 
 * 4)  Count and compare:  O(n)
 * - radix/bucket/counting sort
 * 
 * references:
 * http://interactivepython.org/runestone/static/pythonds/AlgorithmAnalysis/analysis.html?highlight=anagram
 * 
 * 
 * Similarly, finding the max in an array.
 * 1) Brute force solution: O(n^2) running time by compare each element with every other element in the list using 2 for loops.
 * 
 * 2) More efficient smarter solution: O(n) running time by iterating over the array, and keeping track of the max value seen so far.
 * 
 * 
 * Similar to the anagram(s1, s2) problem is the list of words and find the strings which are anagrams.
 * http://www.crazyforcode.com/find-anagrams-array-strings/
 * 
 * Problem: You are given an array of strings and you have to print all the anagrams within the array. 
 * ex. ["bat", "code", "cat", "tab", "cab", "crazy", "act"]
 * 
 * Method 1 (Brute Force): O(n^4)
 * 2 for loops with operation being O(n^2) = O(n^4)
 * 
 * Method 2 ():            O(n^3)
 * after sorting: ["abt", "cdeo", "act", "abt", "abc", "acryz", "act"]
 * 
 * Method 3 ():            O(n^2)
 * after sorting: ["abt", ""abc", abt", "acryz", "act", "act", "act", "cdeo"]
 * 
 * Method 3 modifies:      O(n)
 * 
 * 
 * some good reading on the diffs between counting sort, radix sort, and bucket sort.
 * http://stackoverflow.com/questions/14368392/radix-sort-vs-counting-sort-vs-bucket-sort-whats-the-difference
 * 
 * Counting sort -- simple buckets, simple processing, memory overhead
 * Radix sort -- simple buckets, sophisticated processing, speed overhead (and still need additional static memory)
 * Bucket sort -- sophisticated buckets, simple processing, requires dynamic memory, good in average
 * 
 * Radix and bucket sorts thus are two useful generalizations of counting sort. They have a lot in common with counting sort and with each other but in every case we are losing something and winning something. Software engineering is about a balance between these opportunities.
 * 
 */

public class Ex14{

    private static String sort(String s){
        //you have to convert String -> char[] in the function, otherwise it complains about void type. Don't really understand why.
        char[] data = s.toLowerCase().toCharArray();

        java.util.Arrays.sort(data);    //Arrays.sort sorts in-place
        return new String(data).trim(); //remove space chars at begin and end
    }


    //sorts using system sort, probably quicksort so O(n lg n ) run time
    public static boolean isAnagramSort(String s1, String s2){
        return sort(s1).equals(sort(s2));
    }

    //uses COUNTING SORT to count freq of each char in s1, then sub char in s2
    //O(2n) run time, O(1) constant memory b/c mem size doesn't depend on input size
    public static boolean isAnagram(String s1, String s2){
    //TODO: Doesn't return correct answer with sentence anagrams when different number of space chars.

        if( s1.length() != s2.length() ) return false;

        int[] letters = new int[256];   //size of ASCII charset (assumption)

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        for(int i=0; i < s1.length(); ++i){
            int c = s1.charAt(i);
            ++letters[c];
        }

        for(int i=0; i < s2.length(); ++i){
            int c = s2.charAt(i);
            if( --letters[c] < 0 ) return false;
        }

        return true;
    }

    public static void main(String args[]){
        String s1 = "Repeat";
        String s2 = "Repeatrepeat";
        System.out.printf("isAnagramSort: %s, %s: %s\n", s1, s2, isAnagramSort(s1,s2));
        System.out.printf("isAnagram:     %s, %s: %s\n", s1, s2, isAnagram(s1,s2));

        s1 = "heart";
        s2 = "earth";
        System.out.printf("isAnagramSort: %s, %s: %s\n", s1, s2, isAnagramSort(s1,s2));
        System.out.printf("isAnagram:     %s, %s: %s\n", s1, s2, isAnagram(s1,s2));

        s1 = "Dog";
        s2 = "God";
        System.out.printf("isAnagramSort: %s, %s: %s\n", s1, s2, isAnagramSort(s1,s2));
        System.out.printf("isAnagram:     %s, %s: %s\n", s1, s2, isAnagram(s1,s2));

        s1 = "say it with flowers";
        s2 = "we flirt so this way";
        System.out.printf("isAnagramSort: %s, %s: %s\n", s1, s2, isAnagramSort(s1,s2));
        System.out.printf("isAnagram:     %s, %s: %s\n", s1, s2, isAnagram(s1,s2));

  }

}
