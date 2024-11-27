public class Shortest_distance_after_road_addition_queries_i {
    class Solution {
        int target;
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            target = n - 1;
            List<List<Pair>> graph = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                graph.add(new ArrayList<>());
                graph.get(i).add(new Pair(i + 1, 1));
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int node = queries[i][0];
                int nextNode = queries[i][1];
                graph.get(node).add(new Pair(nextNode, 1));
                ans[i] = dijkstra(n, graph);
            }
    
            return ans;
        }
    
        public int dijkstra(int n, List<List<Pair>> graph) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[0] = 0;
            PriorityQueue<Pair> queue = new PriorityQueue<>();
            queue.offer(new Pair(0, 0));
    
            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                int nodeId = current.nodeId;
    
                if (nodeId == target) {
                    return distances[nodeId];
                }
    
                for (Pair neighbor : graph.get(nodeId)) {
                    int newDistance = distances[nodeId] + neighbor.distance;
    
                    if (newDistance < distances[neighbor.nodeId]) {
                        distances[neighbor.nodeId] = newDistance;
                        queue.offer(new Pair(neighbor.nodeId, newDistance));
                    }
                }
            }
    
            return distances[target];
        }
    
        private class Pair implements Comparable<Pair>{
            int nodeId;
            int distance;
    
            Pair(int nodeId, int distance) {
                this.nodeId = nodeId;
                this.distance = distance;
            }
            
            @Override
            public int compareTo(Pair other) {
                return Integer.compare(this.distance, other.distance);
            }
        }
    }
}
