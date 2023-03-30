package Leetcode_75.Sliding_window_two_pointer;

public class Longest_repeating_character_replacement {
    public int characterReplacement(String s, int k) {
        int maxSub = 0;
        int left = 0;
        int right = 0;
        char[] freq = new char[26];
        for (char ch : s.toCharArray()){
            freq[ch - 'A']++;
        }
        int count = 0;
        for (int i = 0; i < freq.length; i++){
            if (freq[i] == 0){
                continue;
            }
            left = 0;
            right = 0;
            count = 0;
            while (right < s.length()){
                if (s.charAt(right) - 'A' == i){
                    count++;
                }
                while (!isValid(left, right, count, k)){
                    if (s.charAt(left) - 'A' == i){
                        count--;
                    }
                    left++;
                }
                maxSub = Math.max(maxSub, windowSize(left, right));
                right++;
            }
        }
        return maxSub;
    }
    private int windowSize(int left, int right){
        return right - left + 1;
    }
    private boolean isValid(int left, int right, int count, int k){
        if (windowSize(left, right) -  count > k){
            return false;
        } else {
            return true;
        }
    }
}
