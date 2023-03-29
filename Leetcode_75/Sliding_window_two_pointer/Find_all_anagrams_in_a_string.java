package Leetcode_75.Sliding_window_two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_all_anagrams_in_a_string{
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] windowChars = new char[26];
        char[] pChars = new char[26];
        for (char ch : p.toCharArray()){
            pChars[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < s.length()){
            char ch = s.charAt(right);
            windowChars[ch - 'a']++;
            if (right - left == p.length() - 1){
                if (Arrays.equals(windowChars, pChars)){
                    res.add(left);    
                }
                windowChars[s.charAt(left) - 'a']--;
                left++;                
            }
            right++;
        }
        return res;
    }
}