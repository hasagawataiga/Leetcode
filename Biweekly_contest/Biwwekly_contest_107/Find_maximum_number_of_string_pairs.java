package Biweekly_contest.Biwwekly_contest_107;

import java.util.HashMap;
import java.util.Map;

public class Find_maximum_number_of_string_pairs{
    public int maximumNumberOfStringPairs(String[] words) {
        if (words.length == 1){
            return 0;
        }
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i]) && map.get(words[i]) > 0){
                count++;
                map.put(words[i], map.get(words[i]) - 1);
            } else {
                String reverseStr = reverse(words[i]);
                map.put(reverseStr, map.getOrDefault(map.get(reverseStr), 0) + 1);
            }
        }
        return count;
    }
    private String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}