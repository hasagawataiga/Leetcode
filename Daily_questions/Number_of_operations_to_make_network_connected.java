package Daily_questions;
import java.util.ArrayList;
import java.util.List;

public class Number_of_operations_to_make_network_connected{
    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }

        // Build adjacency list for graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }

        // Initialize visited array and number of connected components
        boolean[] visited = new boolean[n];
        int numComponents = 0;

        // Perform DFS to count number of connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numComponents++;
                dfs(i, visited, graph);
            }
        }

        // Return number of cables needed to connect all components
        return numComponents - 1;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }
}