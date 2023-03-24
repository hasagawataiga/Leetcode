package Data_structure_plan.Data_structure_I;

// Use Binary Search algorithm as an array
// Assume this matrix as a 1d array by
//  left = 0
//  right = m * n - 1; (the last element of the matrix)
//      then figure the row and col of middle out via formula : midRow = mid/n;
//                                                              midCol = mid%n;
//                  because mid = midRow*n + midCol;
public class Search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
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
