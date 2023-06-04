package Contest.Contest348;

public class Minimize_string_length {
    public int minimizedStringLength(String s) {
        int[] container = new int[26];
        for (int i = 0; i < s.length(); i++){
            container[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++){
            if (container[i] > 0){
                count++;
            }
        }
        return count;
    }
}
