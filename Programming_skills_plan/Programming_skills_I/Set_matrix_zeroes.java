package Programming_skills_plan.Programming_skills_I;

import java.util.ArrayList;
import java.util.List;

public class Set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < rows.size(); i++){
            int row = rows.get(i);
            for (int j = 0; j < n; j++){
                matrix[row][j] = 0;
            }
        }
        for (int i = 0; i < cols.size(); i++){
            int col = cols.get(i);
            for (int j = 0; j < m; j++){
                matrix[j][col] = 0;
            }
        }
    }
}
