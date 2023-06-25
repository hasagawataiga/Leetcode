public class Count_all_possible_routes {
    int mod = 1_000_000_007;
    int count = 0;
    int n;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        boolean[][] visited = new boolean[n][fuel + 1];
        travel(locations, dp, visited, start, finish, fuel);
        return dp[start][fuel];
    }
    private void travel(int[] locations, int[][] dp, boolean[][] visited, int index, int end, int fuel){
        if (visited[index][fuel]){
            return;
        }
        visited[index][fuel] = true;
        
        int temp = 0;
        if (index == end){
            temp++;
        }
        if (fuel == 0){
            dp[index][fuel] = temp;
            return;
        }
        // If the fuel need to go from index to finish city is greater than the fuel left -> dp[index][fuel] = 0;
        // Whatever route use, it could not reach the finish city from index city
        if (fuel > 0 && Math.abs(locations[index] - locations[end]) > fuel){
            return;
        }
        for (int i = 0; i < n; i++){
            if (i == index){
                continue;
            }
            int fuelUsed = Math.abs(locations[index] - locations[i]);
            if (fuel - fuelUsed >= 0){
                travel(locations, dp, visited, i, end, fuel - fuelUsed);
                temp = (temp + dp[i][fuel - fuelUsed]) % mod;
            }
        }
        dp[index][fuel] = temp;
    }
}
