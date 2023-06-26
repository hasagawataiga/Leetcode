package Leetcode_75.Binary_search;

import java.util.Arrays;

public class Successfull_pairs_of_spells_and_potions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++){
            int left = 0;
            int right = potions.length - 1;
            long spell = spells[i];
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (spell * potions[mid] >= success){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }
}
