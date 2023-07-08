package Biweekly_contest.Biwwekly_contest_108;

public class Number_of_black_blocks {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        int[][] grid = new int[m - 1][n - 1];
        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {0, -1}, {0, 0}};
        long[] res = new long[5];
        int x = 0;
        int y = 0;
        for (int i = 0; i < coordinates.length; i++){
            
                for (int k = 0; k < directions.length; k++){
                    x = coordinates[i][0] + directions[k][0];
                    y = coordinates[i][1] + directions[k][1];
                    if (x < 0 || x >= m - 1 || y < 0 || y >= n - 1){
                        continue;
                    }
                    grid[x][y]++;
                }
        }
        for (int i = 0; i < m - 1; i++){
            for (int j = 0; j < n - 1; j++){
                res[grid[i][j]]++;
            }
        }
        return res;
    }
}
