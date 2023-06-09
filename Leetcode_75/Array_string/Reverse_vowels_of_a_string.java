package Leetcode_75.Array_string;

public class Reverse_vowels_of_a_string {
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] sChars = s.toCharArray();
        while (left < right){
            if (isVowel(sChars[left]) && isVowel(sChars[right])){
                swapChars(sChars, left, right);
                left++;
                right--;
            } else if (!isVowel(sChars[left])){
                left++;
            } else {
                right--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : sChars){
            sb.append(ch);
        }
        return sb.toString();
    }
    private void swapChars(char[] chars, int left, int right){
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }
    private boolean isVowel(char ch){
        switch (ch){
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
