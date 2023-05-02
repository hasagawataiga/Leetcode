public class Gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1){
            if (gas[0] >= cost[0]){
                return 0;
            } else {
                return -1;
            }
        }
        for (int i = 0; i < gas.length; i++){
            if (gas[i] - cost[i] > 0){
                if (isValid(gas, cost, i)){
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean isValid(int[] gas, int[] cost, int index){
        int gasTank = 0;
        for (int i = index; i < gas.length; i++){
            gasTank += gas[i];
            gasTank -= cost[i];
            if (gasTank < 0){
                return false;
            }
        }
        for (int i = 0; i < index; i++){
            gasTank += gas[i];
            gasTank -= cost[i];
            if (gasTank < 0){
                return false;
            }
        }
        return true;
    }
}
