import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(determinateBuildString(input));
    }

    public static String determinateBuildString(String input){
        String[] inputs = input.split("\\s");
        Map<Character, Integer> firstWord =  new HashMap<>(), secondWord = new HashMap<>();

        fillCountsWords(firstWord, inputs[0]);
        fillCountsWords(secondWord, inputs[1]);

        return validateBuildWords(firstWord, secondWord) ? "YES" : "NO";
    }

    public static void fillCountsWords(Map<Character, Integer> mapWord, String word){
        for(int i = 0; i < word.length(); i++)
            mapWord.put(word.charAt(i), !mapWord.containsKey(word.charAt(i)) ? 1 : (mapWord.get(word.charAt(i)) + 1));
    }

    public static Boolean validateBuildWords(Map<Character, Integer> firstWord, Map<Character, Integer> secondWord){
        if (firstWord.size() == secondWord.size()) {
            for(Map.Entry<Character, Integer> index : secondWord.entrySet()){
                if(firstWord.containsKey(index.getKey())){
                    if(index.getValue() < firstWord.get(index.getKey())) return false;
                }
                else return false;
            }
        }

        return true;
    }
}
