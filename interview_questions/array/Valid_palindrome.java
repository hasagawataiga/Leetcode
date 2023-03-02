public class Valid_palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        int length = s.length();
        for (int i = 0; i < length/2; i++){
            if (s.charAt(i) != s.charAt(length - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
