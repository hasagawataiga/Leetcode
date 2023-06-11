package Biweekly_contest.Biwwekly_contest_106;

public class Find_the_longest_semi_repetitive_substring {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        if (n < 2){
            return 1;
        }
        int[] container = new int[10];
        int left = 0;
        int right = 0;
        int max = 2;
        int pair = -1;
        while (right < 2){
            int val = s.charAt(right) - '0';
            container[val]++;
            if (container[val] == 2){
                pair = val;
            }
            right++;
        }
        while (right < n){
            int val = s.charAt(right) - '0';
            container[val]++;
            if (container[val] == 3 && pair == val){
                while (container[val] == 3){
                    int prevVal = s.charAt(left) - '0';
                    container[prevVal]--;
                    left++;
                }
            } else if (container[val] > 1 && pair != -1){
                boolean isDel = false;
                while (!isDel){
                    int prevVal = s.charAt(left) - '0';
                    container[prevVal]--;
                    if (container[prevVal] == 1){
                        isDel = true;
                    }
                    left++;
                }
                pair = val;
            } else if (container[val] > 1 && pair == -1){
                pair = val;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
