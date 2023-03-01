public class Reverse_string{
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length/2; i++){
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }
    private void swap (char[] s, int firstChar, int secondChar){
        char temp = s[firstChar];
        s[firstChar] = s[secondChar];
    }
}