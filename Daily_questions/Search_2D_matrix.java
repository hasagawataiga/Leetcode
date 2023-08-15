public class Search_2D_matrix {
    ublic boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int midRow = mid / n;
            int midCol = mid % n;
            if (matrix[midRow][midCol] > target){
                right = mid - 1;
            } else if (matrix[midRow][midCol] < target){
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
