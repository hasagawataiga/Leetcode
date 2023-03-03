public class Longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        int shortestStrIndex = 0;
        // Find the most shortest String in array
        for (int i = 0; i < strs.length; i++){
            if (strs[shortestStrIndex].length() > strs[i].length()){
                shortestStrIndex = i;
            }
        }
        // Compares every char in the shortest string to the other strings in the array
        // the index of chars are similar in every single strings
        for (int i = 0; i < strs[shortestStrIndex].length(); i++){
            // Use a char variable to reduce the times .charAt() method will be called
            char ch = strs[shortestStrIndex].charAt(i);
            for (int j = 0; j < strs.length; j++){
                if (ch != strs[j].charAt(i)){
                    return strs[shortestStrIndex].substring(0, i);
                }
            }
        }
        return strs[shortestStrIndex];
    }
}
