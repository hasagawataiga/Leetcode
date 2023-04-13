package Algorithm_plan.Sliding_window;

public class Permutation_in_string {
    public boolean checkInclusion(String s1, String s2) {
        int[] chars = new int[26];
        for (char ch : s1.toCharArray()){
            chars[ch - 'a']++;
        }
        int length = s1.length();
        int right = 0;
        int left = 0;
        int[] window = new int[26];
        int count = 0;
        while (right < s2.length()){
            if (right - left + 1 > length){
                char leftChar = s2.charAt(left);
                window[leftChar - 'a']--;
                if (window[leftChar - 'a'] < chars[leftChar - 'a']){
                    count--;
                }
                left++;
            }
            char rightChar = s2.charAt(right);
            window[rightChar - 'a']++;
            if (window[rightChar - 'a'] <= chars[rightChar - 'a']){
                count++;
            }
            if (count == length){
                return true;
            }
            right++;
        }
        return false;
    }
}
