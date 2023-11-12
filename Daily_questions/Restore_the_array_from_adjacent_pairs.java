import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restore_the_array_from_adjacent_pairs {
    int[] res;
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int x = pair[0];
            int y = pair[1];
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList<>());
            }
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList<>());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int head = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                head = num;
                break;
            }
        }
        res = new int[graph.size()];
        dfs(graph, Integer.MAX_VALUE, head, 0);
        return res;
    }
    private void dfs(Map<Integer, List<Integer>> graph, int prev, int x, int i) {
        res[i] = x;
        List<Integer> list = graph.get(x);
        for (int num : list) {
            if (num != prev) {
                dfs(graph, x, num, i + 1);
            }
        }
    }
}
