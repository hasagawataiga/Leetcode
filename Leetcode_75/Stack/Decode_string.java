package Leetcode_75.Stack;

import java.util.Stack;

public class Decode_string {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int num = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(cur);
                cur = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (int i = numStack.pop(); i > 0; i--) {
                    cur.append(tmp);
                }
            } else {
                cur.append(c);
            }
        }
        
        return cur.toString();
    }
}
