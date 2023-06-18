public class Total_distance_traveled {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int total = 0;
        while (mainTank > 4){
            mainTank -= 5;
            total += 5;
            if (additionalTank > 0){
                mainTank++;
                additionalTank--;
            }
        }
        total += mainTank;
        return total * 10;
    }
}
