package Leetcode_75.Hashmap;

import java.util.HashSet;
import java.util.Set;

public class Unique_number_of_occurences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] container = new int[2001];
        for (int num : arr){
            container[num + 1000]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int count : container){
            if (count == 0){
                continue;
            }
            if (set.contains(count)){
                return false;
            }
            set.add(count);
        }
        return true;
    }
}
