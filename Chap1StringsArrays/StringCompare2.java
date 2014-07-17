public class StringCompare2{

    public static void main(String[] args){

        String str1 = new String("Hello");      //Strings are immutable
        StringBuilder str2 = new StringBuilder("World"); //StringBuilder is mutable

        //System.out.println(str1.reverse()); //this won't work, String has no reverse method. Also, Strings are immutable.
        System.out.println(str2.reverse());

    }

}
