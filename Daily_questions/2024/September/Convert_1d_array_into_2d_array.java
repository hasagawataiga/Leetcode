class Convert_1d_array_into_2d_array {
    class Solution {
        public int[][] construct2DArray(int[] original, int m, int n) {
            if (original.length != m * n) {
                return new int[][]{};
            }
            int[][] res = new int[m][n];
            int index = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = original[index++];
                }
            }
            return res;
        }
    }
}