package Programming_skills_plan.Programming_skills_I;

public class Find_nearest_point_that_has_the_same_x_or_y_coordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < points.length; i++){
            if (points[i][0] == x || points[i][1] == y){
                int diff = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (min > diff){
                    min = diff;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }
}
