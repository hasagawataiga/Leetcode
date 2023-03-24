package Data_structure_plan.Data_structure_I;

public class Valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        // Initialize boolean arrays to keep track of digits in each row,   column, and sub-box
        boolean[][] rowUsed = new boolean[9][9];
        boolean[][] colUsed = new boolean[9][9];
        boolean[][] subBoxUsed = new boolean[9][9];

        // Iterate through each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue; // Ignore empty cells
                }

                int digit = c - '1'; // Convert character to digit (0-8)

                // Check if digit has already appeared in row, column, or sub-box
                if (rowUsed[i][digit] || colUsed[j][digit] || subBoxUsed[(i / 3) * 3 + j / 3][digit]) {
                    return false;
                }

                // Update boolean arrays to mark digit as used in corresponding row, column, and sub-box
                rowUsed[i][digit] = true;
                colUsed[j][digit] = true;
                subBoxUsed[(i / 3) * 3 + j / 3][digit] = true;
            }
        }

        return true;
    }
}
