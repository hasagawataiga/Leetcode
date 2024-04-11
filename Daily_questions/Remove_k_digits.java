import java.util.Stack;

public class Remove_k_digits {
    public String removeKdigits(String num, int k) {
        if (num == null || num.isEmpty()) {
            return "";
        }
        
        Stack<Character> stack = new Stack<>();
        stack.push(num.charAt(0));
        
        for (int i = 1; i < num.length(); i++) {
            char digit = num.charAt(i);
            
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop(); // remove peak
                k--;
            }
            
            stack.push(digit);
        }
        
        while (k > 0) {
            stack.pop(); // now we just want to remove any additional elements from the end
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        String res = sb.toString().replaceFirst("^0+(?!$)", "");
        
        return res.isEmpty() ? "0" : res;
    }
}
