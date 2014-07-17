/*
Program demos whether Java is pass-by-ref or pass-by-val.

Inspired by the article on whether Java is pass-by-value or pass-by-reference.

sources: 
http://javadude.com/articles/passbyvalue.htm

http://stackoverflow.com/questions/12757841/are-arrays-passed-by-value-or-passed-by-reference-in-java
(Real passing by reference involves passing the address of a variable so that the variable can be updated. This is NOT what happens when you pass an array in Java.)

http://stackoverflow.com/questions/3486393/java-string-value-change-in-function
*/
public class PassingJavaReferences{

    private static void some_function(StringBuffer the_reference){

        the_reference = new StringBuffer("World.");
        //can't do this like you can in c/c++
        //where you get address of object: &the_reference
        //this is b/c the new StringBuffer object assigns the reference to the local in the scope of the method.
        
        //you mistakenly think that it is like
        //the_reference.replace(0, the_reference.length(), " World.");
        
        //TL;DR
        //the_reference = new StringBuffer("World.");
        //          NOT THE SAME AS
        //the_reference.replace(0, the_reference.length(), " World.");
        //b/c one tries to change the reference directly (the first statement) like a C-style &the_reference = new StringBuffere("World.");
        //and one follows the refrence to the object and changes a field in the object
    }

    private static void swap(Integer x, Integer y){
        Integer tmp = x;
        x = y;
        y = tmp;
    }




    public static void main(String args[]){

        //EXAMPLE 1
        StringBuffer data = new StringBuffer("Hello");

        System.out.println("Before: " + data);
        some_function(data);
        //If it was pass by refrence, the refrence would be changed to
        //the new string "World." but data still points to "Hello".
        //People mistaken it for something else
        //i.e. the_reference.setNewValue("World.")
        System.out.println("After: " + data);


        System.out.println("\n\n");

        //EXAMPLE 2
        Integer var1 = new Integer(10);
        Integer var2 = new Integer(20);

        System.out.printf("Before:\nvar1: %d, var2: %d", var1, var2);
        swap(var1, var2);
        System.out.printf("\nAfter:\nvar1: %d, var2: %d\n", var1, var2);
        System.out.println("Values were NOT swapped!");
        //since values were not swapped,
        //the arguments var1 and var2, were COPIED 
        //into the parameters of the swap function.
        
        /*
        //in c/c++ you could do something like this:
        void swap(SomeType& arg1, Sometype& arg2) {
            SomeType temp = arg1;
            arg1 = arg2;
            arg2 = temp;
        }

        ...

        SomeType var1 = ...; // value "A"
        SomeType var2 = ...; // value "B"
        swap(var1, var2); // swaps their values!
        // now var1 has value "B" and var2 has value "A"
        */

    }
}
