package interview_questions.string;
import java.util.HashMap;

public class First_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> container = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (container.putIfAbsent(ch, 1) != null){
                container.put(ch, container.get(ch) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (container.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }
}
