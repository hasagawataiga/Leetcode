
public Valid_anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] container = new int[26];
        for (int i = 0; i < s.length(); i++) {
            container[s.charAt(i) - 'a']++;
            container[t.charAt(i) - 'a']--;
        }
        for (int element : container) {
            if (element != 0) {
                return false;
            }
        }
        return true;
    }
}