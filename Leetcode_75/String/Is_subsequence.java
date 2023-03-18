package Leetcode_75.String;


public class Is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        int j = 0;
        for (int i = 0; i < lengthS; i++){
            boolean isExisted = false;
            while (j < lengthT && !isExisted){
                if (s.charAt(i) == t.charAt(j)){
                    isExisted = true;
                }
                j++;
            }
            if (!isExisted){
                return false;
            }
        }
        return true;
    }
}
