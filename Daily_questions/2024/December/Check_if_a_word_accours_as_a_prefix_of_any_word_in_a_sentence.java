public class Check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence {
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            int length = searchWord.length();
            int index = 0;
            for (String word : words) {
                index++;
                if (word.length() < length) {
                    continue;
                }
                if (word.substring(0, length).equals(searchWord)) {
                    return index;
                }
            }
            
            return -1;
        }
    }
}