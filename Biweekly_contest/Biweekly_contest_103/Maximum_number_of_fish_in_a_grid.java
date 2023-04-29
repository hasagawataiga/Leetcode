package Biweekly_contest.Biweekly_contest_103;


// Hard
public class Maximum_number_of_fish_in_a_grid {
    public int findMaxFish(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int max = 0;
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] != 0 && !visited[i][j]){
                    int[] count = new int[1];
                    dfs(grid, visited, r, c, i, j, count);
                    max = Math.max(max, count[0]);
                }
                // System.out.println(max);
            }
        }
        return max;
    }
    private void dfs(int[][] grid, boolean[][] visited, int r, int c, int i, int j, int[] count){
        if (i < 0 || j < 0 || i > r - 1 || j > c - 1 || grid[i][j] == 0){
            return;
        }
        if (visited[i][j]){
            return;
        }
        visited[i][j] = true;
        count[0] += grid[i][j];
        dfs(grid, visited, r, c, i, j + 1, count);
        dfs(grid, visited, r, c, i, j - 1, count);
        dfs(grid, visited, r, c, i + 1, j, count);
        dfs(grid, visited, r, c, i - 1, j, count);
    }
}
