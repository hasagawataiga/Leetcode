

public class Count_sub_islands {
    class Solution {
        int m;
        int n;
        public int countSubIslands(int[][] grid1, int[][] grid2) {
            m = grid1.length;
            n = grid1[0].length;
            boolean[][] isVisited = new boolean[m][n];
            int landCount = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid1[i][j] == 0 || grid2[i][j] == 0 || isVisited[i][j]) {
                        continue;
                    }
                    boolean isValid = true;
                    if (traversal(grid1, grid2, i, j, isVisited, isValid)) {
                        landCount++;
                    }
                }
            }
   
            return landCount; 
        }
    
        private boolean traversal(int[][] grid1, int[][] grid2, int i, int j, boolean[][] isVisited, boolean isValid) {
            if (i < 0 || i == m || j < 0 || j == n || grid2[i][j] == 0 || isVisited[i][j]) {
                return isValid;
            }
            isVisited[i][j] = true;
            if (grid1[i][j] == 0) {
                isValid = false;
            }
            isValid = traversal(grid1, grid2, i + 1, j, isVisited, isValid);
            isValid = traversal(grid1, grid2, i - 1, j, isVisited, isValid);
            isValid = traversal(grid1, grid2, i, j + 1, isVisited, isValid);
            isValid = traversal(grid1, grid2, i, j - 1, isVisited, isValid);
            return isValid;
        }
    }
}