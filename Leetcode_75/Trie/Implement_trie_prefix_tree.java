package Leetcode_75.Trie;
public class Implement_trie_prefix_tree {
    class Trie {
        String val;
        Trie left;
        Trie right;
        public Trie() {
        }
        public Trie(String val){
            this.val = val;
        }
        public void insert(String word) {
            if (val == null){
                val = word;
            }
            int temp = val.compareTo(word);
            if (temp > 0){
                if (left == null){
                    this.left = new Trie(word);
                } else {
                    left.insert(word);
                }
            } else {
                if (right == null){
                    this.right = new Trie(word);
                } else {
                    right.insert(word);
                }
            }
        }
        
        public boolean search(String word) {
            if (val == null){
                return false;
            }
            if (val.equals(word)){
                return true;
            }
            int temp = val.compareTo(word);
            if (temp > 0){
                if (left == null){
                    return false;
                } else {
                    return left.search(word);
                }
            } else {
                if (right == null){
                    return false;
                } else {
                    return right.search(word);
                }
            }
        }
        
        public boolean startsWith(String prefix) {
            if (val == null){
                return false;
            }
            if (val.startsWith(prefix)){
                return true;
            }
            int temp = val.compareTo(prefix);
            Trie tempTrie;
            if (temp > 0){
                if (left == null){
                    return false;
                } else {
                    return left.startsWith(prefix);
                }
            } else {
                if (right == null){
                    return false;
                } else {
                    return right.startsWith(prefix);
                }
            }
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */    
}
