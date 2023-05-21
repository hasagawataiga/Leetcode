public class Mininum_string_length_after_removing_substrings {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()){
            if (!stack.isEmpty() && isPair(stack.peek(), ch)){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }        
        return stack.size();
    }
    private boolean isPair(char a, char b){
        return (a == 'A' && b == 'B') || (a == 'C' && b == 'D');
    }
}
