public class Find_smallest_letter_greater_than_target {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char ch : letters){
            if (ch > target){
                return ch;
            }
        }
        return letters[0];
    }
}
