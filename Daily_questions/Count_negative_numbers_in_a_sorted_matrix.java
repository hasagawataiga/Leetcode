public class Count_negative_numbers_in_a_sorted_matrix {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = row - 1; i >= 0; i--){
            for (int j = col - 1; j >= 0; j--){
                if (grid[i][j] < 0){
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
