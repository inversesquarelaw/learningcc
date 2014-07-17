import java.io.BufferedReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import java.util.ArrayList;


/*
This program demos the running time difference between String and StringBuffer

Java Strings are immutable. When you add/append to it, it contructs an entirely new string including what you add to it. It requires traversal of the old string.

Use StringBuffer instead, which let's you add/append to that instance of the string

refer to link for explaination: http://stackoverflow.com/questions/4645020/when-to-use-stringbuilder-in-java

example data:
input 2500 lines:
using String: 164748968 ns, usingStringBuffer: 1071284 ns
time1/time2: 153.786454

slow even for small input size, 10 lines:
using String: 107487 ns, usingStringBuffer: 65516 ns
time1/time2: 1.640622 (almost 2x as slow)

500 lines:
using String: 15657741 ns, usingStringBuffer: 504676 ns
time1/time2: 31.025333

doubled original input size:
using String: 639390294 ns, usingStringBuffer: 1478710 ns
time1/time2: 432.397356

quad original input size:
using String: 2559442707 ns, usingStringBuffer: 2622676 ns
time1/time2: 975.889781




*/


public class StringCompare{

    private final static Charset ENCODING = StandardCharsets.UTF_8;

    private static String[] readInput(String filename) throws IOException{
        ArrayList<String> input = new ArrayList<String>();
        Path path = Paths.get(filename);
        try(BufferedReader br = Files.newBufferedReader(path, ENCODING)){
            String line = null;
            while((line = br.readLine()) != null){
                input.add(line);
            }
        }
        return input.toArray(new String[input.size()]);
        //since we don't know the size of file initially, we used ArrayList which can grow in size, then once we know the size, we create an array of that size and return it.
    }

    /* don't use String, very very slow */
    private static String makeSentence1(String[] words){
        String sentence = new String();
        for(String w: words){
            sentence += w;
        }
        return sentence.toString();
    }

    /* use StringBuffer instead, faster */
    private static String makeSentence2(String[] words){
        StringBuffer sentence = new StringBuffer();
        for(String w: words){
            sentence.append(w);
        }
        return sentence.toString();
    }

    public static void main(String[] args){
        long startTime, endTime, time1, time2;
        String[] data = new String[1]; 
        //initialize an array of size 1 to satisfy compiler b/c it wants to ensure that data has data

        try{
            data = readInput("words.data");
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }

        startTime = System.nanoTime();
        makeSentence1(data);
        endTime   = System.nanoTime();
        time1 = endTime - startTime;

        startTime = System.nanoTime();
        makeSentence2(data);
        endTime   = System.nanoTime();
        time2 = endTime - startTime;

        System.out.printf("using String: %d ns, usingStringBuffer: %d ns\n", time1, time2);
        System.out.printf("time1/time2: %f\n", (double)time1/time2);
    }//end main()
}//end StringCompare class
