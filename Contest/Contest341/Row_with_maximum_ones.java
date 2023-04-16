package Contest.Contest341;

public class Row_with_maximum_ones {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row = mat.length;
        int[] res = new int[2];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < row; i++){
            sum = 0;
            for (int j = 0; j < mat[i].length; j++){
                if (mat[i][j] == 1){
                    sum++;
                }
            }
            if (max < sum){
                res[0] = i;
                res[1] = sum;
                max = sum;
            }
        }
        return res;
    }
}
