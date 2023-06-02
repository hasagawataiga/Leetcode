import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Denote_the_maximum_bombs {
    // class Bomb{
    //     int x;
    //     int y;
    //     int r;
    //     public Bomb(int x, int y, int r){
    //         this.x = x;
    //         this.y = y;
    //         this.r = r;
    //     }
    //     public boolean isConnected(Bomb otherBomb){
    //         double range = Math.sqrt(Math.pow(Math.abs(x - otherBomb.getX()), 2) + Math.pow(Math.abs(y - otherBomb.getY()), 2));
    //         if (range < r){
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }
    //     public int getX(){
    //         return x;
    //     }
    //     public int getY(){
    //         return y;
    //     }
    //     public int getR(){
    //         return r;
    //     }
    // }
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j){
                    continue;
                }
                int x = Math.abs(bombs[i][0] - bombs[j][0]);
                int y = Math.abs(bombs[i][1] - bombs[j][1]);
                int r = bombs[i][2];
                if ((double)x * x + (double)y * y <= (double)r * r){
                    map.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int max = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            max = Math.max(max, dfs(map, i, new boolean[n]));
        }
        return max;
    }
    private int dfs(Map<Integer, List<Integer>> map, int bomb, boolean[] visited){
        visited[bomb] = true;
        int count = 1;
        List<Integer> neighbor = map.getOrDefault(bomb, new ArrayList<>());
        for (int i = 0; i < neighbor.size(); i++){
            if (!visited[neighbor.get(i)]){
                count += dfs(map, neighbor.get(i), visited);
            }
        }
        return count;
    }
}
