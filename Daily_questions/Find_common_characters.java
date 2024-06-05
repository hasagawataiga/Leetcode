import java.util.ArrayList;
import java.util.List;

public class Find_common_characters {
        public List<String> commonChars(String[] words) {
        int length = words.length;
        int[][] charsContainer = new int[26][length];
        for (int i = 0; i < length; i++) {
            for (char ch : words[i].toCharArray()) {
                charsContainer[ch - 'a'][i]++;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < charsContainer.length; i++) {
            int min = length;
            for (int j = 0; j < charsContainer[i].length; j++) {
                min = Math.min(min, charsContainer[i][j]);
            }
            while (min-- > 0) {
                ans.add((char)('a' + i) + "");
            }
        }
        return ans;
    }
}