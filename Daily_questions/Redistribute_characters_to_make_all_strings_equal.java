public class Redistribute_characters_to_make_all_strings_equal {
    public boolean makeEqual(String[] words) {
        int[] chars = new int[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                chars[ch - 'a']++;
            }
        }
        for (int ch : chars) {
            if (ch % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
