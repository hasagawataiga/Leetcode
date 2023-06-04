
// DFS approaching
public class Number_of_provinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected[0].length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                province(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    private void province(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;
        for (int i = 0; i < isConnected[city].length; i++){
            if (i == city){
                continue;
            }
            if (!visited[i] && isConnected[city][i] == 1){
                province(isConnected, visited, i);
            }
        }
    }
}
