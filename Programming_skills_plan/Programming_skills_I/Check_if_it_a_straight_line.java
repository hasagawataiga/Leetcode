package Programming_skills_plan.Programming_skills_I;

public class Check_if_it_a_straight_line {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3){
            return true;
        }
        int x1 = coordinates[0][0];
        int x2 = coordinates[1][0];
        int y1 = coordinates[0][1];
        int y2 = coordinates[1][1];
        double slope = (y2 - y1) * (x2 - x1);
        for (int i = 2; i < coordinates.length; i++){
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            double slope2 = (y2 - y) * (x2 - x);
            if (slope != slope2){
                return false;
            }
        }
        return true;
    }
}
