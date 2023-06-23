package Leetcode_75.Graph_DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// BFS approach
// It could be multi oranges inflate in the beginging, so we have to adjust a little bit for our algorithm (still using BFS)
// As usually, there would be a Queue<Pair> store the first spot and count the minutes
// For the case many spots inflate as the same time, we use List<Queue<Pair>> queues to store all the rotten oranges in the beginning
// Then, inflating is happening for all the init spots (rotten oranges)
// count++ after a loop
// and stop when there is no freshs could be rotten
// return count if no fresh orange left, -1 otherwise
public class Rotting_oranges {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row;
    int col;
    int freshs = 0;
    public int orangesRotting(int[][] grid) {
        this.row = grid.length;
        this.col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        List<Queue<Pair>> queues = new ArrayList<>();
        int count = 0;
        // Init rotten oragens (the begin spots)
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 2){
                    Queue<Pair> queue = new LinkedList<>();
                    queue.offer(new Pair(i, j));
                    queues.add(queue);
                } else if (grid[i][j] == 1){
                    freshs++;
                }
            }
        }
        // Use prev to check whether the fresh oranges are rotten within this minute or not
        int prev = 0;
        while (freshs > 0 && prev != freshs){
            prev = freshs;
            for (Queue<Pair> queue : queues){
                bfs(grid, visited, queue);
            }
            count++;
        }
        return freshs == 0 ? count : -1;
    }
    // Adjust a little bit for our BFS
    // it must be loop once instead of usual way (multiple times)
    private void bfs(int[][] grid, boolean[][] visited, Queue<Pair> queue){
        int size = queue.size();
        for (int i = 0; i < size; i++){
            Pair temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            for (int j = 0; j < dirs.length; j++){
                int newX = x + dirs[j][0];
                int newY = y + dirs[j][1];
                if (newX >= 0 && newX < row && newY >=0 && newY < col 
                && !visited[newX][newY] && grid[newX][newY] == 1){
                    queue.offer(new Pair(newX, newY));
                    visited[newX][newY] = true;
                    freshs--;
                }
            }
        }
    }
}
