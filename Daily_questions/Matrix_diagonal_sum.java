

public class Matrix_diagonal_sum{
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int row = mat.length;
        for (int i = 0; i < row; i++){
            if (i + i == row - 1){
                sum += mat[i][i];
            } else {
                sum += mat[i][i];
                sum += mat[i][row - 1 - i];
            }
        }
        return sum;
    }
}