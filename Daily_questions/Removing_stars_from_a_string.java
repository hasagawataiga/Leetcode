import java.util.Stack;

public class Removing_stars_from_a_string {
    public String removeStars(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()){
            int ch = s.charAt(i) - 'a';
            if (ch >= 0 && ch <= 26){
                stack.push(ch);
            } else {
                stack.pop();
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            int num = stack.pop();
            char ch = (char)(num + 'a');
            sb.append(ch);
        }

        return sb.reverse().toString();
    }
}
