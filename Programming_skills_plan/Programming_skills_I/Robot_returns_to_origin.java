package Programming_skills_plan.Programming_skills_I;

public class Robot_returns_to_origin {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        for (int i = 0; i < moves.length(); i++){
            char move = moves.charAt(i);
            switch (move){
                case 'L':
                    horizontal--;
                    break;
                case 'R':
                    horizontal++;
                    break;
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
            }
        }
        if (horizontal == 0 && vertical == 0){
            return true;
        } else {
            return false;
        }
    }
}
