package Programming_skills_plan.Programming_skills_I;

public class Reshape_the_matrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        int cells = rows * cols;
        if (cells != r * c || (rows == r && cols == c)){
            return mat;
        }
        int[] tempArray = new int[cells];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                tempArray[cols * i + j] = mat[i][j];
            }
        }
        int index = 0;
        int[][] newArray = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                newArray[i][j] = tempArray[index++];
            }
        }
        return newArray;
    }
}
