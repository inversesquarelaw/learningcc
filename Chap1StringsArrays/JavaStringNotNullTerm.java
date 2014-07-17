class JavaStringNotNullTerm{
    
    public static void main(String[] args){
        String my_str = "Hello World.";
        char[] my_str_char = my_str.toCharArray(); //NOT null terminated

        for( char letter: my_str_char ){
            System.out.printf("letter: %s,\tascii: %d\n", letter, (int)letter);
        }

        //System.out.println("char: " + my_str_char[my_str.length()]);
        //my_str_char doesn't have a length()

    }

}
