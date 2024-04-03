public class Word_search {
    int row;
    int col;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (traversal(board, new boolean[row][col], word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean traversal(char[][] board, boolean[][] checked, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }   
        if (checked[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        checked[i][j] = true;
        boolean first = traversal(board, checked, word, i + 1, j, index + 1);
        boolean second = traversal(board, checked,word, i - 1, j, index + 1);
        boolean third = traversal(board, checked, word, i, j + 1, index + 1);
        boolean fourth = traversal(board, checked, word, i, j - 1, index + 1);
        if (first || second || third || fourth) {
            return true;
        }
        checked[i][j] = false;
        return false;
    }
}
