package Recursion.Principle_of_recursion;


public class Reverse_string {
    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }
    private char[] reverseString(char[] s, int start, int end){
        if (start >= end){
            return s;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        return reverseString(s, start + 1, end - 1);
    }
}