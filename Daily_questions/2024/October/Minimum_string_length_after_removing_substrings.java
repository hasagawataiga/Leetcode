import java.util.Stack;

public class Minimum_string_length_after_removing_substrings {
    class Solution {
        public int minLength(String s) {
            Stack<Character> stack = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (!stack.isEmpty() && isPair(stack.peek(), ch)) {
                    stack.pop(); // Remove the pair
                } else {
                    stack.push(ch); // Otherwise, push the current character
                }
            }

            return stack.size();
        }

        private boolean isPair(char ch1, char ch2) {
            return (ch1 == 'A' && ch2 == 'B') || (ch1 == 'C' && ch2 == 'D');
        }
    }
}
