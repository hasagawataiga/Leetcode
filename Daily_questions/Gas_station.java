


// Greedy approachg
public class Gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTank = 0;
        int startPos = 0;
        for (int i = 0; i < gas.length; i++){
            gasTank += gas[i] - cost[i];
            if (gasTank < 0){
                startPos = i + 1;
                gasTank = 0;
            }
        }
        for (int i = 0; i <= startPos; i++){
            gasTank += gas[i] - cost[i];
            if (gasTank < 0){
                return -1;
            }
        }
        return gasTank >= 0 ? startPos : -1;
    }
}