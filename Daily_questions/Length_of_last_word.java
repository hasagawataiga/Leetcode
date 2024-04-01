public class Length_of_last_word {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        return strs[strs.length - 1].length();
    }
    // Second approach
    // public int lengthOfLastWord(String s) {
    //     int length = s.length();
    //     int start = length - 1;
    //     for (; start >= 0; start--) {
    //         if (s.charAt(start) != ' ') {
    //             break;
    //         }
    //     }
    //     int end = start;
    //     for (; start >= 0; start--) {
    //         if (s.charAt(start) == ' ') {
    //             break;
    //         }
    //     }
    //     return end - start;
    // }
}