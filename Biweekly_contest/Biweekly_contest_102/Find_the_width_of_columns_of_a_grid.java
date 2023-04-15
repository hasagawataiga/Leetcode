package Biweekly_contest.Biweekly_contest_102;

public class Find_the_width_of_columns_of_a_grid {
    public int[] findColumnWidth(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] res = new int[col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                String valStr = grid[i][j] + "";
                res[j] = Math.max(res[j], valStr.length());
            }
        }
        return res;
    }
}
