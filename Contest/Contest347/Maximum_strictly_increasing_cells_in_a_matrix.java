package Contest.Contest347;

public class Maximum_strictly_increasing_cells_in_a_matrix {
    public int maxIncreasingCells(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int max = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!visited[i][j]){
                    max = Math.max(max, findPath(mat, dp, visited, i, j, row, col, mat[i][j]));
                }
            }
        }
        return max + 1;
    }
    private int findPath(int[][] mat, int[][] dp, boolean[][] visited, int a, int b, int row, int col, int val){
        if (visited[a][b]){
            return dp[a][b];
        }
        visited[a][b] = true;
        int max = 0;
        for (int i = 0; i < row; i++){
            if (mat[i][b] > val){
                max = Math.max(max, 1 + findPath(mat, dp, visited, i, b, row, col, mat[i][b]));
            }
        }
        for (int j = 0; j < col; j++){
            if (mat[a][j] > val){
                max = Math.max(max, 1 + findPath(mat, dp, visited, a, j, row, col, mat[a][j]));
            }
        }
        dp[a][b] = max;
        return max;
    }
}
