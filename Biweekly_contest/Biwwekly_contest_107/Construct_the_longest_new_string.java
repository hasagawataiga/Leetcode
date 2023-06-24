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
        if (visited[x][y][z]){
            return;
        }
        visited[x][y][z] = true;
        int temp = 0;
        if (prev == 0){
            if (y > 0){
                concate(dp, visited, x, y - 1, z, 1);
                dp[x][y][z] = 2 + dp[x][y - 1][z];
            }
            
        } else if (prev == 1){
            if (x > 0){
                concate(dp, visited, x - 1, y, z, 0);
                temp = Math.max(temp, dp[x - 1][y][z]);
            }
            if (z > 0){
                concate(dp, visited, x, y, z - 1, 2);
                temp = Math.max(temp, dp[x][y][z - 1]);
            }
            dp[x][y][z] = temp + 2;
        } else {
            if (x > 0){
                concate(dp, visited, x - 1, y, z, 0);
                temp = Math.max(temp, dp[x - 1][y][z]);
            }
            if (z > 0){
                concate(dp, visited, x, y, z - 1, 2);
                temp = Math.max(temp, dp[x][y][z - 1]);
            }
            dp[x][y][z] = temp + 2;
        }
    }
}
