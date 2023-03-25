
public class Valid_parentheses {
    public boolean isValid(String s) {
        int length = s.length();
		// The string must has even length
        if (length%2 == 1){
            return false;
        }
		// char[] as a stack
		// push the open parentheses 
		// and check whether the close parentheses is proper position and character whenever reachs it
        char[] stack = new char[length];
        // We want to check the s.charAt(i) to the last open parentheses in stack
        //  so that why we use stack[++pointer] for store open parentheses and stack[pointer] (pointer-- after that)
        //  instead of init pointer = 0, stack[pointer] (pointer++ after that) for store open parentheses
        //      this make the code more complex
        int pointer = -1;
        int index = 0;
        while (index < length){
            char ch = s.charAt(index++);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack[++pointer] = ch;
            } else if (pointer < 0){
                return false;
            } else if ((ch == ')') && (stack[pointer] == '(')){
                pointer--;
            } else if ((ch == ']') && (stack[pointer] == '[')){
                pointer--;
            } else if ((ch == '}') && (stack[pointer] == '{')){
                pointer--;
            } else {
                return false;
            }
        }
        // If the parentheses are valid, the pointer at the end must be -1
        //  otherwise, there would be at least 1 character left in the stack
        return pointer == -1;
    }
}