import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Shortest_path_to_get_all_keys {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
    }
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Pair curr = new Pair(0, 0);
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(curr);
        boolean[][] visited = new boolean[row][col];
        Set<Integer> keyCollected = new HashSet<>();
        int keys = countKeys(grid);
        // System.out.println(keys);
        int count = 0;
        while (keyCollected.size() < keys && !queue.isEmpty()){
            // queue = new LinkedList<>();
            visited[curr.getX()][curr.getY()] = true;
            int steps = bfs(grid, queue, visited, keyCollected, row, col);
            visited = new boolean[row][col];
            queue = new LinkedList<>();
            if (steps > 0){
                count += steps;
                queue.offer(curr);
            }
        }
        // return keyCollected.size() == keys ? count : -1;
        return count;
    }
    private int bfs(String[] grid, Queue<Pair> queue, boolean[][] visited, Set<Integer> keyCollected, int row, int col){
        int steps = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Pair coord = queue.poll();
                for (int j = 0; j < directions.length; j++){
                    int newX = coord.getX() + directions[j][0];
                    int newY = coord.getY() + directions[j][1];
                    if (newX < 0 || newX >= row || newY < 0 || newY >= col || visited[newX][newY]){
                        continue;
                    }
                    char ch = grid[newX].charAt(newY);
                    visited[newX][newY] = true;
                    if (ch >= 'a' && ch <= 'f'){
                        if (keyCollected.add(ch - 'a')){
                            curr = new Pair(newX, newY);
                            return steps + 1;
                        }
                        queue.offer(new Pair(newX, newY));
                    } else if (ch == '.'){
                        queue.offer(new Pair(newX, newY));
                    } else if (ch >= 'A' && ch <= 'F'){
                        if (keyCollected.contains(ch - 'A')){
                            queue.offer(new Pair(newX, newY));
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    private int countKeys(String[] grid){
        int keys = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length(); j++){
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f'){
                    keys++;
                }
            }
        }
        return keys;
    }
}
