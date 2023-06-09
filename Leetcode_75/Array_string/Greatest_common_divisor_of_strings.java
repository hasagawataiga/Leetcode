package Leetcode_75.Array_string;

public class Greatest_common_divisor_of_strings {
    public String gcdOfStrings(String str1, String str2) {
        int i = 0;
        int n1 = str1.length();
        int n2 = str2.length();
        String res = "";
        while (i < n1 && i < n2){
            if (str1.charAt(i) != str2.charAt(i)){
                break;
            }
            if (isDivided(str1, i) && isDivided(str2, i)){
                res = str1.substring(0, i + 1);
            }
            i++;
        }
        return res;
    }
    private boolean isDivided(String str, int index){
        String[] temp = str.split(str.substring(0, index + 1));
        for (int i = 0; i < temp.length; i++){
            if (!temp[i].isEmpty()){
                return false;
            }
        }
        return true;
    }
}
