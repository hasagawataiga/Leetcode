package Contest.Contest347;




public class Difference_of_number_of_distinct_values_on_diagonals{
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                res[i][j] = difference(grid, i, j, r, c);
            }
        }
        return res;
    }
    private int difference(int[][] grid, int a, int b, int r, int c){
        int bottomRight = 0;
        int topLeft = 0;
        int i = a + 1;
        int j = b + 1;
        int[] nums = new int[51];
        while (i < r && j < c){
            if (nums[grid[i][j]] == 0){
                nums[grid[i][j]]++;
                bottomRight++;
            }
            i++;
            j++;
        }
        i = a - 1;
        j = b - 1;
        nums = new int[51];
        while (i >= 0 && j >= 0){
            if (nums[grid[i][j]] == 0){
                nums[grid[i][j]]++;
                topLeft++;
            }
            i--;
            j--;
        }
        // System.out.print(bottomRight + "," + topLeft);
        // System.out.println();
        return Math.abs(bottomRight - topLeft);
    }
}