import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Modify_graph_edge_weights {
    class Solution {
        public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
            int[][] res = new int[n][3];
            Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                graph.putIfAbsent(u, new ArrayList<>());
                graph.putIfAbsent(v, new ArrayList<>());
                graph.get(u).add(new Pair<>(v, edges[i][2]));
                graph.get(v).add(new Pair<>(u, edges[i][2]));
            }
            return res;
        }

        private int bfs(Map<Integer, List<Pair<Integer, Integer>>> graph, List<CustomEdge> path, int index, int destination, int curr, int target, boolean fixable) {
            if (index == destination) {
                if (fixable && curr < target) {
                    modifyWeight(path, curr, target);
                    return curr;
                } else {
                    path = new ArrayList<>();
                    return curr;
                }
            }
            List<Pair<Integer, Integer>> neighbors = graph.get(index);
            for (Pair<Integer, Integer> neighbor : neighbors) {
                
            }

        }

        private void modifyWeight(List<CustomEdge> path, int val, int target) {
            int sum = 0;
            int firstModified = -1;
            for (int i = 0; i < path.size(); i++) {
                if (path.get(i).getDist() != -1) {
                    sum += path.get(i).getDist();
                    continue;
                }
                if (firstModified == -1) {
                    firstModified = i;
                }
                path.get(i).setDist(1);
                sum++;
            }
            if (sum > target) {
                path = new ArrayList<>();
            } else {
                path.get(firstModified).setDist(target - sum);
            }
        }
    }

    class CustomEdge {
        int u;
        int v;
        int dist;
        CustomEdge (int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
        public int getU() {return this.u;}
        public int getV() {return this.v;}
        public int getDist() {return this.dist;}
        public void setDist(int dist) {this.dist = dist;}

    }
}
