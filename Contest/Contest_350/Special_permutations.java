package Contest.Contest_350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Special_permutations {
    int perm = 0;
    int mod = 1_000_000_007;
    int n;
    public int specialPerm(int[] nums) {
        Map<Integer, List<Integer>> container = new HashMap<>();
        n = nums.length;
        for (int num : nums){
            container.put(num, new ArrayList<>());
        }
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if ((nums[i] % nums[j] == 0) || (nums[j] % nums[i] == 0)){
                    container.get(nums[i]).add(nums[j]);
                    container.get(nums[j]).add(nums[i]);
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            dfs(container, new HashSet<>(), nums[i]);
                        perm %= mod;
            // System.out.println();
        }
        return perm % mod;
    }
    private void dfs(Map<Integer, List<Integer>> container, Set<Integer> visited, int val){
        visited.add(val);
        if (visited.size() == n){
            perm++;
            visited.remove(val);
            return;
        }
        List<Integer> list = container.get(val);
        for (int i = 0; i < list.size(); i++){
            if (!visited.contains(list.get(i))){
                dfs(container, visited, list.get(i));
            }
        }
        visited.remove(val);
        // printSet(visited);
    }
    // private void printSet(Set<Integer> set){
    //     for (int num : set){
    //         System.out.print(num + ",");
    //     }
    //     System.out.println();
    // }
    // private void printMap(Map<Integer, List<Integer>> map){
    //     for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
    //         int key = entry.getKey();
    //         System.out.print("Key: " + key + ", Value: ");
    //         List<Integer> value = entry.getValue();
    //         for (int i = 0; i < value.size(); i++){
    //             System.out.print(value.get(i) + ",");
    //         }
    //         System.out.println();
    //     }
    // }
}
