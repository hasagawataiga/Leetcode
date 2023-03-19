package Daily_questions;

public class Design_add_and_search_words_data_structure {
    class WordDictionary {
    
        class TrieNode {
            boolean isWord;
            TrieNode[] children;
            TrieNode() {
                isWord = false;
                children = new TrieNode[26];
            }
        }
        
        TrieNode root;
        public WordDictionary() {
            root = new TrieNode();
        }
        
        // Example:
        // d-r-o-w     e-x-a-m-p-l-e
        //       |     |       |
        //       R O O T   s   a-b
        //         |   |   |
        // h-e-l-l-o   o-r-c-a
        // But we won't store the char/string directly into the TrieNode
        //  instead, we store the int value by (word.charAt(i) - 'a')
        //  it gave the same result but more efficience
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
        
        public boolean search(String word) {
            return searchHelper(word, 0, root);
        }
        
        private boolean searchHelper(String word, int index, TrieNode node) {
            if (node == null) {
                return false;
            }
            // Index == word.length() causes 2 result:
            //  1. First iteration: index == word.length() == 0, means word == "" --> return node.isWord
            //  2. Later iteration: index == word.length() != 0, means every previous characters in word matches with a word stored in dictionary
            //  Note: return node.isWord instead of true because there is an exception: when the node.isWord = false means the last character is null, then return false although the index == word.length()
            if (index == word.length()) {
                return node.isWord;
            }
            // Using recursion the check the char in node.children (the one is checked) and the char in word are equal at s specific index
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (searchHelper(word, index+1, node.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int childIndex = c - 'a';
                return searchHelper(word, index+1, node.children[childIndex]);
            }
        }
    }
}
