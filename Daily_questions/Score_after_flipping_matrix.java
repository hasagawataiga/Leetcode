public class Score_after_flipping_matrix {
    int rows;
    int cols;
    public int matrixScore(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int mostRightVal = 1 << (cols - 1);
        sum += mostRightVal * rows;
        for (int i = 1; i < cols; i++) {
            int ones = countOne(grid, i);
            int val = 1 << (cols - 1 - i);
            if (ones * 2 < rows) {
                for (int j = 0; j < rows; j++) {
                    grid[j][i] ^= 1;
                }
                sum += val * (rows - ones);
            } else {
                sum += val * ones;
            }
        }
        return sum;
    }
    private int countOne (int[][] grid, int col) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            if (grid[i][col] == 1) {
                count++;
            }
        }
        return count;
    }
}
