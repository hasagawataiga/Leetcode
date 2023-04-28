import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Using DFS approach 
// And graph
// Group all strings which are similar to each other by mapping
// After that, use DFS to traversal all the elements once
// Count++ each time see a new group
public class Similar_string_groups {
    public int numSimilarGroups(String[] strs) {
        int length = strs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (isSimilar(strs[i], strs[j])){
                    map.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    map.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }
        int count = 0;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++){
            if (!visited[i]){
                count++;
                dfs(map, visited, i);
            }
        }
        return count;
    }
    private boolean isSimilar(String s1, String s2){
        int diff = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }
    private void dfs(Map<Integer, List<Integer>> map, boolean[] visited, int node){
        if (visited[node]){
            return;
        }
        if (!map.containsKey(node)){
            return;
        }
        visited[node] = true;
        for (int similar : map.get(node)){
            dfs(map, visited, similar);
        }
    }
}
