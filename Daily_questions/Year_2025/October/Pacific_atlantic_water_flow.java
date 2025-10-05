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
            boolean[][] isChecked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // isChecked = new boolean[m][n];
                    if (isChecked[i][j]) {
                        continue;
                    }
                    traversal(heights, isChecked, i, j);
                    // System.out.println("[" + i + " " + j + "]: " + paths[i][j][0] + " " + paths[i][j][1]);
                    // debug(paths);
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (paths[i][j][0] && paths[i][j][1]) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(i);
                        curr.add(j);
                        res.add(curr);
                    }
                }
            }

            return res;
        }

        private void debug(boolean[][][] arr) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    String ch1 = arr[i][j][0] ? "T" : "F";
                    String ch2 = arr[i][j][1] ? "T" : "F";
                    System.out.print(ch1 + ch2 + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        private void traversal(int[][] heights, boolean[][] isChecked, int i, int j) {
            if (isChecked[i][j]) {
                return;
            }
            isChecked[i][j] = true;
            if (i == 0 || j == 0) {
                paths[i][j][0] = true;
            }
            if (i == m - 1 || j == n - 1) {
                paths[i][j][1] = true;
            }
            if (paths[i][j][0] && paths[i][j][1]) {
                return;
            }

            if (i + 1 < m && heights[i + 1][j] <= heights[i][j]) {
                traversal(heights, isChecked, i + 1, j);
                paths[i][j][0] = paths[i][j][0] || paths[i + 1][j][0];
                paths[i][j][1] = paths[i][j][1] || paths[i + 1][j][1];  
            }
            if (i - 1 >= 0 && heights[i - 1][j] <= heights[i][j]) {
                traversal(heights, isChecked, i - 1, j);
                paths[i][j][0] = paths[i][j][0] || paths[i - 1][j][0];
                paths[i][j][1] = paths[i][j][1] || paths[i - 1][j][1];            
            }
            if (j + 1 < n && heights[i][j + 1] <= heights[i][j]) {
                traversal(heights, isChecked, i, j + 1);
                paths[i][j][0] = paths[i][j][0] || paths[i][j + 1][0];
                paths[i][j][1] = paths[i][j][1] || paths[i][j + 1][1];  
            }
            if (j - 1 >= 0 && heights[i][j - 1] <= heights[i][j]) {
                traversal(heights, isChecked, i, j - 1);
                paths[i][j][0] = paths[i][j][0] || paths[i][j - 1][0];
                paths[i][j][1] = paths[i][j][1] || paths[i][j - 1][1];  
            }
            return;
        }
    }
}
