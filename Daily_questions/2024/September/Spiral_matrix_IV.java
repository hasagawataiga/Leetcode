import java.util.Arrays;

public class Spiral_matrix_IV {
    class Solution {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] vectors = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int direction = 0;
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(matrix[i], - 1);
            }
            int currX = 0;
            int currY = 0;
            if (head == null) return matrix;
            int[][] boundaries = new int[2][2];
            boundaries[0][0] = 0; //minX
            boundaries[0][1] = m - 1; //maxX
            boundaries[1][0] = 0; //minY
            boundaries[1][1] = n - 1; //maxY
            while (head != null && boundaries[0][0] <= boundaries[0][1] && boundaries[1][0] <= boundaries[1][1]) {
                matrix[currX][currY] = head.val;
                head = head.next;
                int nextX = currX + vectors[direction][0];
                int nextY = currY + vectors[direction][1];
                if (nextX > boundaries[0][1] || nextX < boundaries[0][0]
                || nextY > boundaries[1][1] || nextY < boundaries[1][0]
                || matrix[nextX][nextY] != -1) {
                    boundaries = updateBoundaries(boundaries, direction);
                    direction = changeDirection(direction);
                }
                currX += vectors[direction][0];
                currY += vectors[direction][1];
            }
            return matrix;
        }
    
        private int changeDirection (int currDirection) {
            return (currDirection + 1) % 4;
        }
    
        private int[][] updateBoundaries (int[][] boundaries, int currDirection) {
            switch (currDirection) {
                case 0:
                    boundaries[0][0]++;
                    break;
                case 1:
                    boundaries[1][1]--;
                    break;
                case 2:
                    boundaries[0][1]--;
                    break;
                case 3:
                    boundaries[1][0]++;
                    break;
            }
            return boundaries;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}