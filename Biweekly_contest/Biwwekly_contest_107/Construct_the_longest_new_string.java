package Biweekly_contest.Biwwekly_contest_107;

public class Construct_the_longest_new_string {
    // 0: "AA"      1: "BB"     2: "CC"
    public int longestString(int x, int y, int z) {
        int[][][] dp = new int[x + 1][y + 1][z + 1];
        boolean[][][] visited = new boolean[x + 1][y + 1][z + 1];
        concate(dp, visited, x - 1, y, z, 0);
        concate(dp, visited, x, y - 1, z, 1);
        concate(dp, visited, x, y, z - 1, 2);
        int pickX = dp[x - 1][y][z];
        int pickY = dp[x][y - 1][z];
        int pickZ = dp[x][y][z - 1];
        int max = Math.max(Math.max(pickX, pickY), pickZ);
        return max + 2;
    }
    private void concate(int[][][] dp, boolean[][][] visited, int x, int y, int z, int prev){
        if (x < 0 || y < 0 || z < 0 || visited[x][y][z]){
            return;
        }
        if (x == 0 && y == 0 && z == 0){
            return;
        }
        visited[x][y][z] = true;
        int temp = 0;

        if ((prev == 1 && x > 0) || (prev == 2 && x > 0)){
            concate(dp, visited, x - 1, y, z, 0);
            temp = Math.max(temp, dp[x - 1][y][z]);
        }
        if (prev == 0 && y > 0){
            concate(dp, visited, x, y - 1, z, 1);
            temp = dp[x][y - 1][z];
        }
        if ((prev == 1 && z > 0) || (prev == 2 && z > 0)){
            concate(dp, visited, x, y, z - 1, 2);
            temp = Math.max(temp, dp[x][y][z - 1]);
        }
        dp[x][y][z] = temp + 2;
    }
}
