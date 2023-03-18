package Biweekly_contest.Contest_100;

// Using Binary Search algorithm
public class Minimum_time_to_repair_cars {
    public long repairCars(int[] ranks, int cars) {
        long maxTime = Long.MAX_VALUE;
        long left = 1;
        long right = maxTime;
        long minTime = right;
        while (left <= right){
            long middle = left + (right - left)/2;
            if (check(ranks, cars, middle)){
                minTime = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return minTime;
    }
    // calculate the maximum cars which mechanics can repair
    // If all maximum cars that mechanics can repair is lower than the cars given -> return false
    //  otherwise
    private boolean check(int[] ranks, int cars, long time){
        int length = ranks.length;
        int i = 0;
        while(i < length && cars > 0){
            int rankCars = (int)Math.sqrt(time/ranks[i]);
            cars -= rankCars;
            i++;
        }
        if (cars > 0){
            return false;
        } else {
            return true;
        }
    }
}
