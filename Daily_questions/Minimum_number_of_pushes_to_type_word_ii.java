import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimum_number_of_pushes_to_type_word_ii {
    public int minimumPushes(String word) {
        int[] chars = new int[26];
        for (char ch : word.toCharArray()) {
            chars[ch - 'a']++;
        }
        List<Integer> counts = new ArrayList<>();
        for (int ch : chars) {
            if (ch == 0) {
                continue;
            }
            counts.add(ch);
        }
        Collections.sort(counts, (a, b) -> {
            return b - a;
        });
        int numberOfKeys = 8;
        int sum = 0;
        int currentTypeNeeded = 1;
        for (int count : counts) {
            if (numberOfKeys-- == 0) {
                numberOfKeys = 7;
                currentTypeNeeded++;
            }
            sum += count * currentTypeNeeded;
        }
        return sum;
    }
}