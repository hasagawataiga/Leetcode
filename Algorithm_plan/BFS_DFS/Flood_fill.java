package Algorithm_plan.BFS_DFS;

public class Flood_fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startingColor = image[sr][sc];
        if (startingColor == color){
            return image;
        }
        floodFill(image, sr, sc, color, startingColor);
        return image;
    }
    private void floodFill(int[][] image, int sr, int sc, int color, int startingColor){
        if (sr < 0 || sr >= image.length){
            return;
        }
        if (sc < 0 || sc >= image[sr].length){
            return;
        }
        if (image[sr][sc] != startingColor){
            return;
        }
        image[sr][sc] = color;
        floodFill(image, sr - 1, sc, color, startingColor);
        floodFill(image, sr + 1, sc, color, startingColor);
        floodFill(image, sr, sc - 1, color, startingColor);
        floodFill(image, sr, sc + 1, color, startingColor);
    }
}
