public class Reorder_routes_to_amke_all_paths_lead_to_the_city_zero {
    public static int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            graph[conn[0]].add(conn[1]);
            graph[conn[1]].add(conn[0]);
        }
        int[] incoming = new int[n];
        int[] outgoing = new int[n];
        dfs(0, -1, incoming, outgoing, graph);
        int numChanges = 0;
        for (int i = 1; i < n; i++) {
            if (incoming[i] > outgoing[i]) {
                numChanges += incoming[i] - outgoing[i];
            } else if (outgoing[i] > incoming[i]) {
                numChanges += outgoing[i] - incoming[i];
            }
        }
        return numChanges + 1;
    }

    private static void dfs(int curr, int parent, int[] incoming, int[] outgoing, List<Integer>[] graph) {
        for (int neighbor : graph[curr]) {
            if (neighbor != parent) {
                incoming[neighbor]++;
                outgoing[curr]++;
                dfs(neighbor, curr, incoming, outgoing, graph);
            }
        }
    }
}
