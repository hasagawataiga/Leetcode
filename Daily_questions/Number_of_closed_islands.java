
// DFS algorithm
// Use DFS to traverse all the adjust elements of "0" whenever met it.
// Let's imagine that we will inflate all the "0" connected to eachother as a group and 
//  check there is any "0" in the group at the edges or corners of grid
//  if yes --> return true and increase count to 1
//  otherwise move to the next element
public class Number_of_closed_islands {
    public int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] != 1 && !visited[i][j] && dfs(grid, visited, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean dfs(int[][] grid, boolean[][] visited, int row, int col){
        if (row < 0 || col < 0 || row > grid.length || col > grid[row].length){
            return false;
        }
        if (grid[row][col] == 1){
            return true;
        }
        if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1){
            return false;
        }
        if (visited[row][col]){
            return true;
        }
        visited[row][col] = true;
        boolean adjust1 = dfs(grid, visited, row, col + 1);
        boolean adjust2 = dfs(grid, visited, row, col - 1);
        boolean adjust3 = dfs(grid, visited, row + 1, col);
        boolean adjust4 = dfs(grid, visited, row - 1, col);
        if (adjust1 && adjust2 && adjust3 && adjust4){
            return true;
        } else {
            return false;
        }
    }
}
