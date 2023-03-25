import java.util.ArrayList;
import java.util.List;

public class Count_unreachable_pairs_of_nodes_in_an_undirected_graph {
    public long countPairs(int n, int[][] edges) {
        long total = (long)n * (n - 1) / 2;
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];
        for (int[] edge : edges){
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        long unreachableNodes = total;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int count = dfs(i, list, visited, new int[1]);
                System.out.println(count + " ");
                unreachableNodes -= (long)count * (count - 1) / 2;
            }
        }
        return unreachableNodes;
    }
    private int dfs(int node, List<Integer>[] list, boolean[] visited, int[] count) {
        if (visited[node]){
            return count[0];
        }
        visited[node] = true;
        count[0]++;
        for (int neighbor : list[node]) {
            dfs(neighbor, list, visited, count);
        }
        return count[0];
    }
}
