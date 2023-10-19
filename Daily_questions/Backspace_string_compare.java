import java.util.Stack;

public class Backspace_string_compare{
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> one = traversal(s);
        Stack<Character> two = traversal(t);
        if (one.size() != two.size()){
            return false;
        }
        while (!one.isEmpty()){
            if (one.pop() != two.pop()){
                return false;
            }
        }
        return true;
    }
    private Stack<Character> traversal(String s){
        int length = s.length();
        int i = 0;
        Stack<Character> one = new Stack<>();
        while (i < length){
            if (s.charAt(i) == '#' && !one.isEmpty()){
                one.pop();
            } else if (s.charAt(i) != '#') {
                one.push(s.charAt(i));
            }
            i++;
        }
        return one;
    }
}