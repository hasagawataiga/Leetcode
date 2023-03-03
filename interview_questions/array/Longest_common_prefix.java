public class Longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int arrayIndex = 0;
        int charIndex = 0;
        while (charIndex < strs[0].length()){
            arrayIndex = 0;
            char ch = strs[0].charAt(charIndex);
            while (arrayIndex < (strs.length - 1) && charIndex < strs[arrayIndex + 1].length() && ch == strs[arrayIndex + 1].charAt(charIndex)){
                arrayIndex++;
            }
            if (arrayIndex == strs.length - 1){
                res += ch;
            } else {
                break;
            }
            charIndex++;
        }
        return res;
    }
}
