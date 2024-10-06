public class Sentence_similarity_iii {
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] word1 = sentence1.split(" ");
            String[] word2 = sentence2.split(" ");
            if (word1.length < word2.length) {
                return checkSimilar(word1, word2);
            } else {
                return checkSimilar(word2, word1);
            }
        }
    
        private boolean checkSimilar(String[] str1, String[] str2) {
            int j = 0;
            int gap = str2.length - str1.length;
            for (int i = 0; i < str1.length; i++) {
                if (!str1[i].equals(str2[j])) {
                    j += gap;
                }
                if (j >= str2.length || !str1[i].equals(str2[j])) {
                    return false;
                }
                j++;
            }
            return true;
        }
    }
}