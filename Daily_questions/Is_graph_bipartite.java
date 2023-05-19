



// DFS approach
// Assume that the group A and B were colored (A: 1, B: -1)
// Use DFS to traversal all the nodes
// Return false whenever a node met its member (same color group) from the their neighbor
public class Is_graph_bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++){
            if (visited[i] == 0){
                visited[i] = 1;
                if (!dfs(graph, visited, i, 1)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] visited, int i, int color){
        boolean res = true;
        for (int neighbor : graph[i]){
            if (visited[neighbor] == 0){
                visited[neighbor] = -1 * color;
                res &= dfs(graph, visited, neighbor, -1 * color);
            } else if (visited[neighbor] == color){
                return false;
            }
        }
        return res;
    }
}
