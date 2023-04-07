
// Using DFS approach
// Iterating along the 4 edges of the grid and use DFS algorithm to find out all land cell connected to the edges
// Step 2: Iterating again the rest cells of grid, whenever reaching a land cell -> count++
public class Number_of_enclaves {
    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i){
            if (grid[i][0] == 1 && !visited[i][0]){
                dfs(grid, visited, i, 0);
            }
            if (grid[i][col - 1] == 1 && !visited[i][col - 1]){
                dfs(grid, visited, i, col - 1);
            }
        }
        for (int i = 0; i < col; ++i){
            if (grid[0][i] == 1 && !visited[0][i]){
                dfs(grid, visited, 0, i);
            }
            if (grid[row - 1][i] == 1 && !visited[row - 1][i]){
                dfs(grid, visited, row - 1, i);
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid, boolean[][] visited, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        if (grid[row][col] == 0){
            return;
        }
        if (visited[row][col]){
            return;
        }
        
        visited[row][col] = true;
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row, col - 1);
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row - 1, col);
        return;
    }
}
