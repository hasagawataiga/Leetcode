package Contest.Contest343;


// Medium
public class First_completely_painted_row_or_column {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] indexes = new int[m * n + 1];
        for (int i = 0; i < arr.length; i++){
            indexes[arr[i]] = i;
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < m; i++){
            max = indexes[mat[i][0]];
            for (int j = 1; j < n; j++){
                max = Math.max(max, indexes[mat[i][j]]);
            }
            min = Math.min(min, max);
        }
        for (int i = 0; i < n; i++){
            max = indexes[mat[0][i]];
            for (int j = 1; j < m; j++){
                max = Math.max(max, indexes[mat[j][i]]);
            }
            min = Math.min(min, max);
        }
        return min;
    }
}
