public class Minimum_speed_to_arrive_on_time {
    public int minSpeedOnTime(int[] dist, double hour) {
        int lo = 1;
        int hi = (int)1e7;
        // for (int num : dist){
        //     hi = Math.max(hi, num);
        // }
        int res = -1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (isValid(dist, hour, mid)){
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    private boolean isValid(int[] dist, double hour, int speed){
        double total = 0;
        for (int i = 0; i < dist.length; i++){
            double time = (double)dist[i] / speed;
            if (i != dist.length - 1){
                total += Math.ceil(time);
            } else {
                total += time;
            }
            if (total > hour){
                return false;
            }
        }
        return true;
    }
}
