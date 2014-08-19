//not working
class Ex15{

    private static void replaceSpaces (char[] str) {
        int spaceCount = 0, newLen, i = 0;

        int len = str.length;

        for( i=0; i < len; ++i ) {
            if(str[i] == ' ')   spaceCount++;
        }

        newLen = len + spaceCount*3;

        char[] newStr = new char[newLen];
        //str[newLen] = '\0';

        for( i = len-1; i >= 0; ++i ) {
            if(str[i] == ' '){      //if space char insert %20
                newStr[newLen-1] = '0';
                newStr[newLen-2] = '2';
                newStr[newLen-3] = '%';
                newLen = newLen - 3;
            }
            else {
                newStr[newLen-1] = str[i];     //if not space char, just copy char
                newLen = newLen - 1;
            }
        }

    }

    public static void main (String args[]) {
        char[] data = {'h', ' ', 'e', 'l', ' ', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};

        System.out.println("Before: " + new String(data));
        replaceSpaces(data);
        System.out.println("After: " + new String(data));
    }
}
