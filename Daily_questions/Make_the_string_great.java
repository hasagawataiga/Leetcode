import java.util.Stack;

public class Make_the_string_great {
    public String makeGood(String s) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(index) - 'A');
                index++;
            } else if (Math.abs(stack.peek() - s.charAt(index) + 'A') == 32) {
                while (!stack.isEmpty() 
                && index < s.length()
                && Math.abs(stack.peek() - s.charAt(index) + 'A') == 32) {
                    stack.pop();
                    index++;
                }
            } else {
                stack.push(s.charAt(index) - 'A');
                index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int ch : stack) {
            sb.append((char)(ch + 'A'));
        }
        return sb.toString();
    }
}