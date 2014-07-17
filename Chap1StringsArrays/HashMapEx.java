import java.util.HashMap;
import java.util.Map;

public class HashMapEx{
    
    public static HashMap<String, Integer> makeHashMap(String[] words){
        HashMap<String, Integer> hm = new HashMap<>();
        for( String w : words ) hm.put( w, w.length() );
        return hm;
    }

    public static void main(String args[]){

        String sentence = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z B D H I J L K M N O W X";
        /*HashMap doesn't hold duplicates*/

        String[] words = sentence.split(" ");

        HashMap<String, Integer> myHashMap = makeHashMap(words);
        for( Map.Entry<String, Integer> element: myHashMap.entrySet() ){
            System.out.println("Key=Val: " + element );
        }

    }
}
