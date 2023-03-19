package Contest.Contest337;

import java.util.HashMap;

public class Check_knight_tour_configuration {
    class Coordinate{
        int row;
        int col;
        Coordinate(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Coordinate> map = new HashMap<>();
        if (grid[0][0] != 0){
            return false;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                map.put(grid[i][j], new Coordinate(i, j));
            }
        }
        for (int i = 0; i < n * n - 1; i++){
            int currRow = map.get(i).row;
            int currCol = map.get(i).col;
            int nextRow = map.get(i + 1).row;
            int nextCol = map.get(i + 1).col;
            int absRow = Math.abs(currRow - nextRow);
            int absCol = Math.abs(currCol - nextCol);
            boolean isValid = false;
            if (absRow == 1 && absCol == 2){
                isValid = true;
            } else if (absRow == 2 && absCol == 1){
                isValid = true;
            }
            System.out.println(i + ": " + currRow + "," + currCol + "|" + (i+1) + ": " + nextRow + "," + nextCol + " - ");
            if (!isValid){
                return false;
            }
        }
        return true;
    }
}
