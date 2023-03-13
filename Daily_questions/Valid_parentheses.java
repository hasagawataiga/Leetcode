package Daily_questions;

import java.util.Stack;

public class Valid_parentheses {
    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        int length = s.length();
        // The string must has even length
        if (length%2 == 1){
            return false;
        }
        char[] array = new char[length];
        for (int i = 0; i < length; i++){
            array[i] = s.charAt(i);
        }
        // Use stack to store the order and the number of parentheses
        //  traversal the string 
        //  whenever reachs a close parentheses, we check whether it is proper position and character
        Stack<Character> stack = new Stack<>();
        stack.push(array[0]);
        int i = 1;
        while (i < length){
            if (array[i] == '(' || array[i] == '[' || array[i] == '{'){
                stack.push(array[i]);
            } else if (stack.empty()){
                return false;
            } else if ((array[i] == ')') && (stack.peek() == '(')){
                stack.pop();
            } else if ((array[i] == ']') && (stack.peek() == '[')){
                stack.pop();
            } else if ((array[i] == '}') && (stack.peek() == '{')){
                stack.pop();
            } else {
                return false;
            }
            i++;
        }
        return stack.empty() && (i == length);
    }
}
