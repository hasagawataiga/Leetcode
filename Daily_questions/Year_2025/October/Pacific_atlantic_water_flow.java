package Daily_questions.Year_2025.October;

import java.util.ArrayList;
import java.util.List;

public class Pacific_atlantic_water_flow {
    class Solution {
        int m = 0;
        int n = 0;
        boolean[][][] paths;
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            m = heights.length;
            n = heights[0].length;
            paths = new boolean[m][n][2];
            List<List<Integer>> res = new ArrayList<>();
            boolean[][] canReachPacific = new boolean[m][n];
            // Go from top edge
            for (int i = 0; i < m; i++) {
                traversal(heights, canReachPacific, i, 0, heights[i][0]);
            }
            // Go from left edge
            for (int j = 0; j < n; j++) {
                traversal(heights, canReachPacific, 0, j, heights[0][j]);
            }

            boolean[][] canReachAtlantic = new boolean[m][n];
            // Go from right edge
            for (int j = 0; j < n; j++) {
                traversal(heights, canReachAtlantic, m - 1, j, heights[m - 1][j]);
            }
            // Go from bottom edge
            for (int i = 0; i < m - 1; i++) {
                traversal(heights, canReachAtlantic, i, n - 1, heights[i][n - 1]);
            }


            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canReachAtlantic[i][j] && canReachPacific[i][j]) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(i);
                        curr.add(j);
                        res.add(curr);
                    }
                }
            }

            return res;
        }

        private void traversal(int[][] heights, boolean[][] canReachOcean, int i, int j, int prevHeight) {
            if (i < 0 || i >= m || j < 0 || j >= n || canReachOcean[i][j] || heights[i][j] < prevHeight) {
                return;
            }

            canReachOcean[i][j] = true;

            traversal(heights, canReachOcean, i + 1, j, heights[i][j]);
            traversal(heights, canReachOcean, i - 1, j, heights[i][j]);
            traversal(heights, canReachOcean, i, j + 1, heights[i][j]);
            traversal(heights, canReachOcean, i, j - 1, heights[i][j]);
        }
    }
}
