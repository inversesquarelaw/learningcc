/*

Chapter 8 Ex 8.1 

Iterative version of getting a fibinacci number.

*/

class Ex81{
    


    /*
    O(n) running time, but uses only O(3) extra space.
    */
    public static int fibiter(int nth){
        if( nth < 0 ) return -1;        //error condition
        if( nth == 0 ) return 0;

        int fn = 0, fn1 = 1, fn2 = 1;
        //fib seed values are: fib(2) = 1, fib(1) = 1

        for( int i=3; i <= nth ; ++i ){
            fn = fn2 + fn1;
            //System.out.printf("%d: fn: %d, fn1: %d, fn2: %d\n", i, fn, fn1, fn2);
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
    }

    /*
    Also O(n) running time, but a recusive fib would take O(n) extra space.
    (each recursive call adds a new layer to the stack, which means O(n) recursive calls uses O(n) memory.)
    */
    public static int fibrec(int nth){
        if      ( nth == 0 ) return 0;
        else if ( nth == 1 ) return 1;
        else if ( nth  > 1 ) return fibrec(nth - 1) +  fibrec(nth - 2);
        else                 return -1;     //error condition
    }

    public static void main(String args[]){

        System.out.printf("\n%dth fib number is: %d\n", 10, fibiter(10));

        System.out.printf("\niter and rec are equal: %s\n", fibiter(10) == fibrec(10));

    }

}
