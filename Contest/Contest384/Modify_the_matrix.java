package Contest.Contest384;

public class Modify_the_matrix {
    int m;
    int n;
    public int[][] modifiedMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] newMatrix = new int[m][n];
        for (int j = 0; j < n; j++) {
            int max = -2;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == -1) {
                    if (max == -2) {
                        max = findMax(matrix, j);
                    }
                    newMatrix[i][j] = max;
                } else {
                    newMatrix[i][j] = matrix[i][j];                    
                }
            }
        }
        return newMatrix;
    }
    private int findMax(int[][] matrix, int col) {
        int max = -2;
        for (int i = 0; i < m; i++) {
            max = Math.max(matrix[i][col], max);
        }
        return max;
    }
}
