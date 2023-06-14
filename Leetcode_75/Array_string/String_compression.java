package Leetcode_75.Array_string;

public class String_compression {
    int curr = 0;
    public int compress(char[] chars) {
        int n = chars.length;
        if (n < 2){
            return n;
        }
        int right = 0;
        while (right < n){
            int count = 1;
            while (right + count < n && chars[right] == chars[right + count]){
                count++;
            }
            chars[curr++] = chars[right];
            if (count > 1){
                numToChars(chars, count);
            }
            right += count;
        }
        return curr;
    }
    private void numToChars(char[] chars, int count){
        if (count != 0){
            numToChars(chars, count / 10);
            chars[curr++] = Character.forDigit(count % 10, 10);
        }
    }
}
