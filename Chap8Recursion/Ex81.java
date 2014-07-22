/*

Chapter 8 Ex 8.1 

Iterative and recursive versions of getting a fibinacci number.

*/

class Ex81{
    


    /*
    O(n) running time, but uses only O(3) extra space.
    */
    public static long fibiter(int nth){
        if( nth < 0 ) return -1;        //error condition
        if( nth == 0 ) return 0;
        //note: no "if n == 1, n == 2" corner cases. it is handled below.

        long fn = 0, fn1 = 1, fn2 = 1;

        for( int i=3; i <= nth ; ++i ){
            fn = fn2 + fn1;
            //System.out.printf("%d: fn: %d, fn1: %d, fn2: %d\n", i, fn, fn1, fn2);
            fn2 = fn1;
            fn1 = fn;
        }
        return fn1;  //return fn1 instead of fn b/c of corner cases fib(1) == fib(2) == 1 and the author didn't want to include another if case (if n == 1, n == 2)
    }

    /*
    Recursive Fib is O(2^n) _EXPONENTIAL_, more precisely is O((goldenratio)^n)
    derivation: 
    T(n <= 1) = O(1)
    T(n) = T(n-1) + T(n-2)  ; solve this using generating functions? or master theorem.
    
    OR refer to http://stackoverflow.com/questions/360748/computational-complexity-of-fibonacci-sequence :
    Just ask yourself how many statements need to execute for F(n) to complete.
    For F(1), the answer is 1 (the first part of the conditional).
    For F(n), the answer is F(n-1) + F(n-2).
    So what function satisfies these rules? Try an:
    an == a(n-1) + a(n-2)
    Divide through by a(n-2):
    a2 == a + 1
    Solve for a and you get (1+sqrt(5))/2, otherwise known as the golden ratio.
    So it takes exponential time.


    O(n) extra space.
    (each recursive call adds a new layer to the stack, which means O(n) recursive calls uses O(n) memory.)
    references:
    http://www.quora.com/Computer-Science/What-is-the-space-complexity-of-a-recursive-fibonacci-function
    http://cs.stackexchange.com/questions/13055/time-complexity-and-space-complexity-in-recursive-algorithm
    */
    public static long fibrec(int nth){
        if      ( nth == 0 ) return 0;
        else if ( nth == 1 ) return 1;
        else if ( nth  > 1 ) return fibrec(nth - 1) +  fibrec(nth - 2);
        else                 return -1;     //error condition
    }

    public static void main(String args[]){


        System.out.printf("\n%dth fib number is: %d\n", 0, fibiter(0));
        System.out.printf("\n%dth fib number is: %d\n", 1, fibiter(1));
        System.out.printf("\n%dth fib number is: %d\n", 2, fibiter(2));
        System.out.printf("\n%dth fib number is: %d\n", 3, fibiter(3));
        System.out.printf("\n%dth fib number is: %d\n", 4, fibiter(4));
        System.out.printf("\n%dth fib number is: %d\n", 5, fibiter(5));
        System.out.printf("\n%dth fib number is: %d\n", 20, fibiter(20));

        System.out.printf("\n%dth fib number is: %d\n", 0, fibrec(0));
        System.out.printf("\n%dth fib number is: %d\n", 1, fibrec(1));
        System.out.printf("\n%dth fib number is: %d\n", 2, fibrec(2));
        System.out.printf("\n%dth fib number is: %d\n", 3, fibrec(3));
        System.out.printf("\n%dth fib number is: %d\n", 4, fibrec(4));
        System.out.printf("\n%dth fib number is: %d\n", 5, fibrec(5));
        System.out.printf("\n%dth fib number is: %d\n", 20, fibrec(20));

        System.out.printf("\niter and rec are equal: %s\n", fibiter(20) == fibrec(20));

    }

}
