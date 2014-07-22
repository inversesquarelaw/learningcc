/*

Demos factorial, both iterative and recursion.
It also compares the running time performance between them.

*/

class Factorial{

    //O(n) running time, O(n) extra space [O(n) rec calls -> O(n) call stack]
    public static long facrec(int n){
        if      (n < 0)             return -1;
        if      (n == 0)            return 1;

        return n * facrec(n - 1);
    }

    //O(n) running time, O(2) extra space [2 local vars: retval, i]
    public static long faciter(int n){
        if (n <  0)     return -1;
        if (n == 0)     return 1;
        
        long retval = 1;
        for( int i=n; i > 0; --i ){
            retval *= i;
        }
        return retval;
    }

    public static void main(String args[]){
        long start, end, time_rec, time_iter;

        start = System.nanoTime();
        System.out.println(faciter(20));
        end = System.nanoTime();
        time_rec = end - start;

        start = System.nanoTime();
        System.out.println(facrec(20));
        end = System.nanoTime();
        time_iter = end - start;

        System.out.printf("iter: %d ns, rec: %d ns\n", time_iter, time_rec);
        System.out.printf("rec/iter: %f", (double)time_rec/time_iter);
    }

}
