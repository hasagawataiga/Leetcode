package Leetcode_75.Graph_DFS_BFS;

public class Flood_fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        floodFill(image, sr, sc, color, visited);
        return image;
    }
    private void floodFill(int[][] image, int sr, int sc, int color, boolean[][] visited){
        if (visited[sr][sc]){
            return;
        } else {
            visited[sr][sc] = true;
        }
        if (sr > 0 && sr < image.length - 1){
            if (image[sr - 1][sc] == image[sr][sc]){
                floodFill(image, sr - 1, sc, color, visited);
            }
            if (image[sr + 1][sc] == image[sr][sc]){
                floodFill(image, sr + 1, sc, color, visited);
            }
        } else if (sr > 0){
            if (image[sr - 1][sc] == image[sr][sc]){
                floodFill(image, sr - 1, sc, color, visited);
            }
        } else {
            if (image[sr + 1][sc] == image[sr][sc]){
                floodFill(image, sr + 1, sc, color, visited);
            }
        }
        if (sc > 0 && sc < image[sr].length - 1){
            if (image[sr][sc - 1] == image[sr][sc]){
                floodFill(image, sr, sc - 1, color, visited);
            }
            if (image[sr][sc + 1] == image[sr][sc]){
                floodFill(image, sr, sc + 1, color, visited);
            }
        } else if (sc > 0){
            if (image[sr][sc - 1] == image[sr][sc]){
                floodFill(image, sr, sc - 1, color, visited);
            }
        } else {
            if (image[sr][sc + 1] == image[sr][sc]){
                floodFill(image, sr, sc + 1, color, visited);
            }
        }
        image[sr][sc] = color;
    }
}
