package Daily_questions.Year_2025.September;

public class Largest_triangle_area {
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double maxSquare = -1;
            for (int i = 0; i < points.length - 2; i++) {
                for (int j = i + 1; j < points.length - 1; j++) {
                    for (int k = j + 1; k < points.length; k++) {
                        maxSquare = Math.max(maxSquare, squareCal(points, i , j , k));
                    }
                }
            }

            return maxSquare;
        }

        private double squareCal(int[][] arr, int a, int b, int c) {
            return 0.5 * Math.abs(arr[a][0] * (arr[b][1] - arr[c][1]) + arr[b][0] * (arr[c][1] - arr[a][1]) + arr[c][0] * (arr[a][1] - arr[b][1]));
        }
    }
}
