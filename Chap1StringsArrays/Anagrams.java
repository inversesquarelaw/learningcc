/*

Demons different ways to solve anagram problem.
i.e. Is str1 an anagram of str2?

Solutions from CC:
1)  Sort both strings and compare each index i, to see if they are the same.
2)  Radix/bucket sort both strings, to see if they have the same count of chars.
    Similar to hashing.

Solutions from Interactive Python:
1)  Check off:          O(n^2)
    - 2 for loops, checking if each char in s1 is in s2

2)  Sort and compare:   O(n lg n)
    - sort s1 and s2 and see if the sorted results are the same

3)  Brute force:        O(2^n)      
    - generate a set of all possible string using chars from s1 and see if s2 in in that set.

4)  Count and compare:  O(n)
    - radix/bucket/counting sort

references:
http://interactivepython.org/runestone/static/pythonds/AlgorithmAnalysis/analysis.html?highlight=anagram


Similarly, finding the max in an array.
1) Brute force solution: O(n^2) running time by compare each element with every other element in the list using 2 for loops.

2) More efficient smarter solution: O(n) running time by iterating over the array, and keeping track of the max value seen so far.


Similar to the anagram(s1, s2) problem is the list of words and find the strings which are anagrams.
http://www.crazyforcode.com/find-anagrams-array-strings/

Problem: You are given an array of strings and you have to print all the anagrams within the array. 
ex. ["bat", "code", "cat", "tab", "cab", "crazy", "act"]

Method 1 (Brute Force): O(n^4)
2 for loops with operation being O(n^2) = O(n^4)

Method 2 ():            O(n^3)
after sorting: ["abt", "cdeo", "act", "abt", "abc", "acryz", "act"]

Method 3 ():            O(n^2)
after sorting: ["abt", ""abc", abt", "acryz", "act", "act", "act", "cdeo"]

Method 3 modifies:      O(n)


some good reading on the diffs between counting sort, radix sort, and bucket sort.
http://stackoverflow.com/questions/14368392/radix-sort-vs-counting-sort-vs-bucket-sort-whats-the-difference

    Counting sort -- simple buckets, simple processing, memory overhead
    Radix sort -- simple buckets, sophisticated processing, speed overhead (and still need additional static memory)
    Bucket sort -- sophisticated buckets, simple processing, requires dynamic memory, good in average

Radix and bucket sorts thus are two useful generalizations of counting sort. They have a lot in common with counting sort and with each other but in every case we are losing something and winning something. Software engineering is about a balance between these opportunities.

*/


public class Anagrams{

    private static void isAnagram(char[] s1, char[] s2){
    }

    public static void main(String args[]){
    }

}
