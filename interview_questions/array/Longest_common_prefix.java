public class Longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        int shortestStrIndex = 0;
        // Find the most shortest String in array
        for (int i = 0; i < strs.length; i++){
            if (strs[i].equals("")){
                return "";
            }
            if (strs[shortestStrIndex].length() > strs[i].length()){
                shortestStrIndex = i;
            }
        }
        if (strs.length < 2){
            return strs[0];
        }
        // Compares every char in the shortest string to the other strings in the array
        // the index of chars are similar in every single strings
        for (int i = 0; i < strs[shortestStrIndex].length(); i++){
            for (int j = 0; j < strs.length; j++){
                if (strs[shortestStrIndex].charAt(i) != strs[j].charAt(i)){
                    return strs[shortestStrIndex].substring(0, i);
                }
            }
        }
        return strs[shortestStrIndex];
    }
}
