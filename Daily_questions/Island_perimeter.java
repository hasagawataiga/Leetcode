public class Island_perimeter {
    int rows;
    int cols;
    int perimeter;
    boolean[][] isChecked;
    public int islandPerimeter(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        isChecked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    perimeter(grid, i, j);
                    return perimeter;
                }
            }
        }
        return 0;
    }
    private void perimeter(int[][] grid, int row, int col) {
        if (row >= rows || row < 0 || col >= cols || col < 0) {
            return;
        }
        if (isChecked[row][col]) {
            return;
        }
        isChecked[row][col] = true;
        if (grid[row][col] == 0) {
            return;
        }
        int estimatedEdges = 4;
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            estimatedEdges--;
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            estimatedEdges--;
        }
        if (row + 1 < rows && grid[row + 1][col] == 1) {
            estimatedEdges--;
        }
        if (col + 1 < cols && grid[row][col + 1] == 1) {
            estimatedEdges--;
        }
        perimeter += estimatedEdges;
        perimeter(grid, row + 1, col);
        perimeter(grid, row - 1, col);
        perimeter(grid, row, col + 1);
        perimeter(grid, row, col - 1);
    }
}
