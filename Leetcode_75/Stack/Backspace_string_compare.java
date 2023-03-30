package Leetcode_75.Stack;

public class Backspace_string_compare {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int count1 = 0;
        int count2 = 0;
        while (i >=0 || j >= 0){
            count1 = 0;
            count2 = 0;
            while (i >= 0 && s.charAt(i) == '#'){
                count1++;
                i--;
            }
            while (i >= 0 && count1 > 0){
                i--;
                count1--;
            }
            while (j >= 0 && t.charAt(j) == '#'){
                count2++;
                j--;
            }
            while (j >= 0 && count2 > 0){
                j--;
                count2--;
            }
            if (j >= 0 && i >= 0 && s.charAt(i) != t.charAt(j)){
                return false;
            } else if ((j >= 0) != (i >= 0)){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
