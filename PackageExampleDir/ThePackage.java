/*

This demos the use of java packages. This is the main component.

*/

package PackageExampleDir;

public class ThePackage{

    public static void print_inside_the_package(){
        System.out.println("printing inside ThePackage class of PackageExampleDir...");
    }

    public static void main(String[] args){
        System.out.println("You can only run this Program by going 1 directory above this file. i.e. 'java PackageExampleDir/ThePacakge'");
        System.out.println("But you compile the .java file in the same director as the file. i.e. 'javac ./ThePackage.java'");
    }

}
