package Dynamic_programming_plan.Dynamic_programming_I;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Minimum_score_of_a_path_between_two_cities {
    public int minScore(int target, int[][] roads) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int dist = roads[i][2];
            map.computeIfAbsent(u, newHashMap -> new HashMap<>()).put(v, dist);
            map.computeIfAbsent(v, newHashMap -> new HashMap<>()).put(u, dist);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Set<Integer> isVisited = new HashSet<>();
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            int u = queue.poll();
            for (Map.Entry<Integer, Integer> entry : map.get(u).entrySet()){
                int v = entry.getKey();
                int dist = entry.getValue();
                if (!isVisited.contains(v)){
                    queue.add(v);
                    isVisited.add(v);
                }
                min = Math.min(min, dist);            
            }
        }
        return min;
    }
}
