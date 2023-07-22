


// From Leetcode Editorial
// Another approach is BFS
public class Knight_probability_in_chessboard {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0){
            return 1L;
        }
        if (n < 3){
            return 0;
        }
        int[][] directions = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        // Initialize the previous and current DP tables
        double[][] prevDp = new double[n][n];
        double[][] currDp = new double[n][n];

        // Set the probability of the starting cell to 1
        prevDp[row][column] = 1;

        // Iterate over the number of moves
        for (int moves = 1; moves <= k; moves++) {
            // Iterate over the cells on the chessboard
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    currDp[i][j] = 0;

                    // Iterate over possible directions
                    for (int[] direction : directions) {
                        int prevI = i - direction[0];
                        int prevJ = j - direction[1];

                        // Check if the previous cell is within the chessboard
                        if (prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n) {
                            // Update the probability by adding the previous probability divided by 8
                            currDp[i][j] += prevDp[prevI][prevJ] / 8;
                        }
                    }
                }
            }

            // Swap the previous and current DP tables
            double[][] temp = prevDp;
            prevDp = currDp;
            currDp = temp;
        }

        // Calculate the total probability by summing up the probabilities for all cells
        double totalProbability = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalProbability += prevDp[i][j];
            }
        }

        // Return the total probability
        return totalProbability;
    }
}
