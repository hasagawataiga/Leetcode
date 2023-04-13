

public class Longest_substring_without_repeating_characters{
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[256];
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            chars[ch]++;
            if (chars[ch] != 1){
                while (j <= i && chars[ch] != 1){
                    chars[s.charAt(j)]--;
                    j++;
                }
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}