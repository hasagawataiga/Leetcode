package Contest.Contest370;

public class Find_champion_i {
    public int findChampion(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < grid.length; j++) {
                if (j == i) {
                    continue;
                }
                if (grid[i][j] != 1 && i != j) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                res = i;
                break;
            }
        }
        return res;
    }
}
