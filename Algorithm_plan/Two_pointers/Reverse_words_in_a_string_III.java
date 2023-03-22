package Algorithm_plan.Two_pointers;

public class Reverse_words_in_a_string_III {
    public String reverseWords(String s) {
        int left = 0, right = 0;
        int n = s.length();
        char[] charArray = s.toCharArray();
        while(right < n){
            if(charArray[right] == ' '){
                reverse(charArray, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        reverse(charArray, left, right - 1);
        return new String(charArray);
    }
    private void reverse(char[] s, int a, int b){
        while (a < b){
            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a++;
            b--;
        }
    }
}
