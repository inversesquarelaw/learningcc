
/*
This programs tests usage of the import of a package that you created yourself.

the other component is the Ex81.java file in the Chap8Recursion dir.

*/

import PackageExampleDir.*;

public class PackageExample{

    public static void main(String args[]){
        PackageExampleDir.ThePackage.print_inside_the_package();
    }
}
