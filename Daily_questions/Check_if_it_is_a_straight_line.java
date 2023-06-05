



//  X1     Y1
//  --  =  --
//  X2     Y2
// X1 * Y2 = X2 * Y1
public class Check_if_it_is_a_straight_line{
    public boolean checkStraightLine(int[][] coordinates) {
        //  if there are only 2 points, it must be in a straight line
        if (coordinates.length < 3){
            return true;
        }
        int deltaX = coordinates[1][0] - coordinates[0][0];
        int deltaY = coordinates[1][1] - coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++){
            int tempDeltaX = coordinates[i][0] - coordinates[0][0];
            int tempDeltaY = coordinates[i][1] - coordinates[0][1];
            if (deltaX * tempDeltaY != deltaY * tempDeltaX){
                return false;
            }
        }
        return true;
    }
}