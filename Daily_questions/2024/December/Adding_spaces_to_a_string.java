public class Adding_spaces_to_a_string {
    class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int prevIndex = 0;
            int index = 0;
            while (index < spaces.length) {
                sb.append(s.substring(prevIndex, spaces[index]));
                sb.append(" ");
                prevIndex = spaces[index++];
            }
            sb.append(s.substring(prevIndex, s.length()));
            return sb.toString();
        }
    }
}