package Leetcode_75.Graph_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Nearest_exit_from_entrance_in_maze {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int steps = 0;
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        queue.offer(new Pair(entrance[0], entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Pair curr = queue.poll();
                for (int[] dir : dirs){
                    int x = curr.x + dir[0];
                    int y = curr.y + dir[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == '.'){
                        if (x == 0 || x == row - 1 || y == 0 || y == col - 1){
                            return steps + 1;
                        }
                        maze[x][y] = '+';
                        queue.offer(new Pair(x, y));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
