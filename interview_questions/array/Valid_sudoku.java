<<<<<<< HEAD
=======
public class Valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] grids = new int[9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.') {
                    continue;
                }
                int value = Character.getNumericValue(board[i][j]);
                int mask = 1 << (value - 1);
                if ((rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (grids[i/3*3 + j/3] & mask) != 0){
                    return false;
                }
                rows[i] |= mask;
                cols[j] |= mask;
                grids[i/3*3 +j/3] |= mask;
            }
        }
        return true;
    }
}
>>>>>>> 5de912d (Rotate Image solution)
