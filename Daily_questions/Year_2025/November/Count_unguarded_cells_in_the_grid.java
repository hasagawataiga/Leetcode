public class Count_unguarded_cells_in_the_grid {
    class Solution {
        public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
            int[][] map = new int[m][n];
            for (int i = 0; i < walls.length; i++) {
                int x = walls[i][0];
                int y = walls[i][1];
                map[x][y] = 2;
            }

            for (int i = 0; i < guards.length; i++) {
                map[guards[i][0]][guards[i][1]] = 3;
            }

            for (int i = 0; i < guards.length; i++) {
                dfs(map, m, n, guards[i][0], guards[i][1]);
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }

            return count;
        }

        private void dfs(int[][] map, int m, int n, int a, int b) {
            // Left Vision
            for (int i = b - 1; i >= 0; i--) {
                if (map[a][i] == 2) {
                    break;
                }
                if (map[a][i] == 3) { 
                    break;
                }
                map[a][i] = 1;
            }
            // Top Vision
            for (int i = a - 1; i >= 0; i--) {
                if (map[i][b] == 2) {
                    break;
                }
                if (map[i][b] == 3) { 
                    break;
                }
                map[i][b] = 1;
            }
            // Right Vision
            for (int i = b + 1; i < n; i++) {
                if (map[a][i] == 2) {
                    break;
                }
                if (map[a][i] == 3) { 
                    break;
                }
                map[a][i] = 1;
            }
            // Bottom Vision
            for (int i = a + 1; i < m; i++) {
                if (map[i][b] == 2) {
                    break;
                }
                if (map[i][b] == 3) { 
                    break;
                }
                map[i][b] = 1;
            }
        }
    }
}
