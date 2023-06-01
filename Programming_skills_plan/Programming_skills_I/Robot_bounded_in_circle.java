package Programming_skills_plan.Programming_skills_I;

public class Robot_bounded_in_circle {
    // Direction: North(0), West(1), South(2), East(3)
    public boolean isRobotBounded(String instructions) {
        int direction = 0;
        int[][] positions = new int[instructions.length()][2];
        int x = 0;
        int y = 0;
        for (int i = 0; i < instructions.length(); i++){
            char instruction = instructions.charAt(i);
            if (instruction == 'L'){
                direction++;
                direction %= 4;
            } else if (instruction == 'R'){
                direction--;
                if (direction < 0){
                    direction = 3;
                }
            }
            if (direction == 0){
                y++;
            } else if (direction == 1){
                x--;
            } else if (direction == 2){
                y--;
            } else {
                x++;
            }
            if (x == 0 && y == 0){
                return true;
            }
            System.out.print(direction + ":" + x + "," + y + " -- ");
        }
        
        return (x == 0 && y == 0) || direction != 0;
    }


    // Direction: North(0), West(1), South(2), East(3)
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;char d='N';  //starting pos and direction of robot
        for(char i : instructions.toCharArray()){
            if(i=='G'){ //updating the curr pos of the robot according to the direction
                if(d=='N'){y++;}
                else if(d=='E'){x++;}
                else if(d=='S'){y--;}
                else{x--;}    
            }
            else if(i=='L'){  // updating direction if left instruction
                if(d=='N'){d='W';}  //change to west, if curr direction is north and so forth according to the left 
                else if(d=='E'){d='N';}
                else if(d=='S'){d='E';}
                else{d='S';}
            }
            else{   //updating direction if right instruction
                if(d=='N'){d='E';}  //change to east, if curr direction is north and so forth according to the right
                else if(d=='E'){d='S';}
                else if(d=='S'){d='W';}
                else{d='N';}
            }
        }
        if(x==0 && y==0 || d!='N'){return true;} //cheacking the final conditions
        return false;
    }
}
