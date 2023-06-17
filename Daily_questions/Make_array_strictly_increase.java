import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Make_array_strictly_increase {
    class Pair{
        int i;
        int curr;
        public Pair(int i, int curr){
            this.i = i;
            this.curr = curr;
        }
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr2){
            set.add(num);
        }
        arr2 = new int[set.size()];
        int i = 0;
        for (int num : set){
            arr2[i++] = num;
        }
        Arrays.sort(arr2);
        Map<Pair, Integer> dp = new HashMap<>();
        int res = swap(arr1, arr2, 0, dp, - 1);
        return res < 2001 ? res : -1;
    }
    private int swap(int[] arr1, int[] arr2, int i, Map<Pair, Integer> dp, int curr){
        if (i >= arr1.length){
            return 0;
        }
        if (dp.containsKey(new Pair(i, curr))){
            return dp.get(new Pair(i, curr));
        }
        int min = 2001;
        if (arr1[i] > curr){
            min = swap(arr1, arr2, i + 1, dp, arr1[i]);
            // min = Math.min(min, swap(arr1, arr2, i + 1, dp, arr1[i]));
        }
        int index = findSmallestGreater(arr2, curr);
        if (index != -1){
            min = Math.min(min, swap(arr1, arr2, i + 1, dp, arr2[index]) + 1);
        }
        dp.put(new Pair(i, curr), min);
        return min;
    }
    private int findSmallestGreater(int[] arr, int val){
        int left = 0;
        int right = arr.length;
        int index = -1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] > val){
                index = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

}
