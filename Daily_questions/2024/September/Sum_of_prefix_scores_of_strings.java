public class Sum_of_prefix_scores_of_strings {
    class Solution {
        public int[] sumPrefixScores(String[] words) {
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            int[] res = new int[words.length];
            for (int i = 0; i < res.length; i++) {
                // String curr = words[i];
                res[i] = trie.sumPrefixScore(words[i]);
            }
            return res;
        }
    }
    
    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
                curr.count++;
                // System.out.println(index + ": " + curr.count);
            }
            // curr.isEndOfWord = true;
        }
    
        // Calculate the sum of scores for each prefix of the word
        public int sumPrefixScore(String word) {
            TrieNode current = root;
            int totalScore = 0;
            
            // Traverse the word in the Trie and accumulate the prefix counts
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (current.children[index] == null) {
                    return totalScore; // This case won't happen since the word was inserted before
                }
                current = current.children[index];
                totalScore += current.count;
            }
            
            return totalScore;
        }
    
        private class TrieNode {
            private TrieNode[] children;
            private int count;
            
            public TrieNode() {
                children = new TrieNode[26];
                count = 0;
            }
        }
    }
}
