import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Path_with_maximum_probability {
    class Pair{
        int node;
        double prob;
        public Pair(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, pathProb));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.prob, b.prob));
        pq.add(new Pair(start, 1.0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            double curProb = cur.prob;
            int curNode = cur.node;
            if (curNode == end) {
                return curProb;
            }
            for (Pair nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nxtNode = nxt.node;
                double pathProb = nxt.prob;
                if (curProb * pathProb > maxProb[nxtNode]) {
                    maxProb[nxtNode] = curProb * pathProb;
                    pq.add(new Pair(nxtNode, maxProb[nxtNode]));
                }
            }
        }

        return 0d;
    }
}
