

public class Maximum_number_of_vowels_in_a_substring_of_given_length{
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        while (right < k){
            char ch = s.charAt(right);
            if (isVowel(ch)){
                count++;
            }
            max = Math.max(max, count);
            right++;
        }
        while (right < n){
            if (isVowel(s.charAt(left))){
                count--;
            }
            left++;
            if (isVowel(s.charAt(right))){
                count++;
            }
            right++;
            max = Math.max(max, count);
        }
        return max;
    }
    private boolean isVowel(char ch){
        if (ch == 'a'){
            return true;
        } else if (ch == 'e'){
            return true;
        } else if (ch == 'i'){
            return true;
        } else if (ch == 'o'){
            return true;
        } else if (ch == 'u'){
            return true;
        }
        return false;
    }
}