import java.util.ArrayList;
import java.util.List;


// Using DFS algorithm
// Approach: if city A can be reached from root, it means that root can not be reached from city A
// Then numChanges++;
// We figure out the direction of the connection by using List<Integer>[] conns
// The original direction is store as normal
//  While the reverse direction is store with the (-)connections[i][0] and connections[i][1] 
// In the DFS method we check the absolute value of connections[i][0] whether is equal to parent

public class Reorder_routes_to_make_all_paths_lead_to_the_city_zero {
    int numChanges = 0;
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] conns = new List[n];
        for (int i = 0; i < n; i++) {
            conns[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            conns[conn[0]].add(conn[1]);
            conns[conn[1]].add(-conn[0]);
        }
        dfs(0, -1, conns);
        return numChanges;
    }

    private void dfs(int curr, int parent, List<Integer>[] conns) {
        for (int neighbor : conns[curr]){
            if (Math.abs(neighbor) == parent){
                continue;
            }
            if (neighbor > 0){
                numChanges++;
            }
            dfs(Math.abs(neighbor), curr, conns);
        }
        
    }
}
