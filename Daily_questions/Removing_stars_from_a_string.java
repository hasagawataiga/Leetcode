
public class Removing_stars_from_a_string {
    public String removeStars(String s) {
        int length = s.length();
        char[] chars = new char[length];
        int index = length - 1;
        int i = index;
        int countStars = 0;
        while (i >= 0){
            char ch = s.charAt(i);
            if (ch == '*'){
                countStars++;
            } else {
                if (countStars > 0){
                    countStars--;
                } else {
                    chars[index] = ch;
                    index--;
                }
            }
            i--;
        }
        return new String(chars, index + 1, length - index - 1);
    }
}
