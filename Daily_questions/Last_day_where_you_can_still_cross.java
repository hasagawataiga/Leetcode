public class Last_day_where_you_can_still_cross {
    boolean isValid = true;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1;
        int right = row * col;
        boolean[][] visited;
        boolean[][] waters = new boolean[row][col];
        int prev = -1;
        while (left < right){
            isValid = false;
            int mid = left + (right - left) / 2;

            // Update the waters array up to the current day
            for (int i = 0; i <= mid; i++) {
                int r = cells[i][0] - 1;
                int c = cells[i][1] - 1;
                waters[r][c] = true;
            }

            visited = new boolean[row][col];
            for (int i = 0; i < col; i++){
                if (!visited[0][i] && !waters[0][i]){
                    dfs(visited, waters, row, col, 0, i);
                }
            }

            // Reset the waters array for the next iteration
            for (int i = 0; i <= mid; i++) {
                int r = cells[i][0] - 1;
                int c = cells[i][1] - 1;
                waters[r][c] = false;
            }

            if (isValid){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private void dfs(boolean[][] visited, boolean[][] waters, int row, int col, int i, int j){
        if (i == row - 1){
            isValid = true;
            return;
        }
        for (int a = 0; a < directions.length; a++){
            int x = i + directions[a][0];
            int y = j + directions[a][1];
            if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y] && !waters[x][y]){
                visited[x][y] = true;
                dfs(visited, waters, row, col, x, y);
            }
        }
    }
}
