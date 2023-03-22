package Data_structure_plan.Data_structure_I;

import java.util.Arrays;
import java.util.List;

public class Pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        int[][] triangle = new int[numRows][];
        for (int i = 0; i < numRows; i++){
            int[] row = new int[i+1];
            row[0] = 1;
            row[i] = 1;
            for (int j = 1; j < i; j++){
                row[j] = triangle[i-1][j] + triangle[i-1][j-1];
            }
            triangle[i] = row;
        }
        return (List)Arrays.asList(triangle);
    }
}
