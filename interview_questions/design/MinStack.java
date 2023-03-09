package interview_questions.design;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    // This subStack is used for storing the min value of the original Stack
    private Stack<Integer> subStack;
    public MinStack() {
        stack = new Stack<>();
        subStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        // Caution!! Remember to cal the subStack.isEmpty() method before the .peek() method
        //  to pretent the null exception
        if (subStack.isEmpty() || subStack.peek() >= val){
            subStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.peek().equals(subStack.peek())){
            subStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return subStack.peek();
    }
}
