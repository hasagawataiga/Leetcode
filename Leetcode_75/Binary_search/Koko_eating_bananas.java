package Leetcode_75.Binary_search;

public class Koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1){
            if (piles[0] <= h){
                return 1;
            } else if (piles[0] % h == 0){
                return piles[0] / h;
            } else {
                return piles[0] / h + 1;
            }
        }
        int min = piles[0];
        int max = piles[0];
        for (int num : piles){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // int res = min;
        int left = 1;
        int right = max;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (isValid(piles, mid) <= h){
                // res = mid;
                right = mid;
            } else {
                // res = mid;
                left = mid + 1;
            }
        }
        return left;
    }
    private int isValid(int[] piles, int bananas){
        int count = 0;
        for (int num : piles){
            // Ceil (num / bananas)
            count += (bananas + num - 1) / bananas;
        }
        return count;
    }
}
