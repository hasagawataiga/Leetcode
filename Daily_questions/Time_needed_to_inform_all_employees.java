import java.util.ArrayList;
import java.util.List;

public class Time_needed_to_inform_all_employees {
    int max = Integer.MIN_VALUE;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++){
            if (manager[i] == -1){
                continue;
            } else {
                list.get(manager[i]).add(i);
            }
        }
        dfs(list, informTime, headID, 0);
        return max;
    }
    private void dfs(List<List<Integer>> list, int[] informTime, int curr, int time){
        max = Math.max(max, time);
        for (int staff : list.get(curr)){
            dfs(list, informTime, staff, time + informTime[curr]);
        }
    }
}
