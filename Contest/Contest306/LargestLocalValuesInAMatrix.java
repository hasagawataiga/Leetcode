

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid){
        int col = grid[0].length;
        int row = grid.length;
        if(col < 3 || row < 3){
            return new int[0][0];
        }
        int[][] result = new int[col-2][row-2];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                result[i][j] = findMax(grid, i, j);
            }
        }
        return result;
    }
    public int findMax (int[][] grid, int a, int b){
        int max = Integer.MIN_VALUE;
        for(int i = a; i < a+3; i++){
            for(int j = b; j < b+3; j++){
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
            }
        }
        return max;
    }
}
