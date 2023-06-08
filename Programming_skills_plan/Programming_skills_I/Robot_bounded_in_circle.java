package Programming_skills_plan.Programming_skills_I;

public class Robot_bounded_in_circle {
    // Direction: North(0), West(1), South(2), East(3)
    public boolean isRobotBounded(String instructions) {
        int direction = 0;
        int x = 0;
        int y = 0;
        int[][] moves = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
        for (int i = 0; i < instructions.length(); ++i){
            char instruction = instructions.charAt(i);
            if (instruction == 'L'){
                direction = (direction + 1) % 4;
            } else if (instruction == 'R'){
                // direction--;
                // if (direction < 0){
                //     direction = 3;
                // }
                direction = (direction + 3) % 4;
            } else {
                x += moves[direction][0];
                y += moves[direction][1];
                // if (direction == 0){
                //     y++;
                // } else if (direction == 1){
                //     x--;
                // } else if (direction == 2){
                //     y--;
                // } else {
                //     x++;
                // }
            }
            
            // if (x == 0 && y == 0){
            //     return true;
            // }
        }
        return (x == 0 && y == 0) || direction != 0;
    }
}