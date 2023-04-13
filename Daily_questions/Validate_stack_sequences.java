import java.util.Stack;

public class Validate_stack_sequences{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        int length = pushed.length;
        while (i < length && j < length){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            i++;
        }
        while (j < length && !stack.isEmpty()){
            if (popped[j] != stack.pop()){
                return false;
            }
            j++;
        }
        if (stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}