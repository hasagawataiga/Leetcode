package Leetcode_75.Stack;

import java.util.Stack;

public class Decode_string {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int count = 0;
        String currStr = "";
        for (char ch : s.toCharArray()){
            if (Character.isDigit(ch)){
                count = count * 10 + (ch - '0');
            } else if (ch == '['){
                countStack.push(count);
                count = 0;
                strStack.push(currStr);
                currStr = "";
            } else if (ch == ']'){
                int times = countStack.pop();
                String prevStr = strStack.pop();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < times; i++){
                    sb.append(currStr);
                }
                currStr = prevStr + sb;
            } else {
                currStr += ch;
            }
        }
        return currStr;
    }
}
