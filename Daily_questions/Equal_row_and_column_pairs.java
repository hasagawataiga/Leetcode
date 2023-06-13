

public class Equal_row_and_column_pairs{
    public class TrieNode{
        int val;
        Map<Integer, TrieNode> children;
        public TrieNode(){
            this.val = 0;
            this.children = new HashMap<>();
        }
    }
    public class Trie{
        TrieNode trie;
        public Trie(){
            this.trie = new TrieNode();
        }
        public void insert(int[] neighbors){
            TrieNode temp = this.trie;
            for (int neighbor : neighbors){
                if (!temp.children.containsKey(neighbor)){
                    temp.children.put(neighbor, new TrieNode());
                }
                temp = temp.children.get(neighbor);
            }
            temp.val++;
        }
        public int search(int[] neighbors){
            TrieNode temp = this.trie;
            for (int neighbor : neighbors){
                if (temp.children.containsKey(neighbor)){
                    temp = temp.children.get(neighbor);
                } else {
                    return 0;
                }
            }
            return temp.val;
        }
    }
    public int equalPairs(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Trie myTrie = new Trie();
        int count = 0;
        for (int i = 0; i < row; i++){
            myTrie.insert(grid[i]);
        }
        for (int i = 0; i < col; i++){
            int[] cols = new int[col];
            for (int j = 0; j < row; j++){
                cols[j] = grid[j][i];
            }
            count += myTrie.search(cols);
        }
        return count;
    }
}