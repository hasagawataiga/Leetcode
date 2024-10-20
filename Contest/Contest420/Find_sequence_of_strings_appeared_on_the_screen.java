import java.util.ArrayList;
import java.util.List;

public class Find_sequence_of_strings_appeared_on_the_screen {
    class Solution {
    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        int curr = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        int index = 0;
        while (index < target.length()) {
            res.add(sb.toString());
            if (sb.charAt(index) == target.charAt(index)) {
                curr = 0;
                sb.append('a');
                index++;
            } else {
                curr++;
                sb.setCharAt(index, (char)(curr + 'a'));
            }
        }
        return res;
    }
}
}
