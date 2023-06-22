package Leetcode_75.Graph_DFS_BFS;

import java.util.List;

public class Keys_and_rooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, visited, 0);
        for (boolean check : visited){
            if (!check){
                return false;
            }
        }
        return true;
    }
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room){
        if (visited[room]){
            return;
        }
        List<Integer> keys = rooms.get(room);
        visited[room] = true;
        for (int key : keys){
            if (!visited[key]){
                dfs(rooms, visited, key);
            }
        }
    }
}
