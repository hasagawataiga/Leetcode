import java.util.*;
class Solution {
    int[][][] cache;
    int[] digits;
    public int countSpecialNumbers(int n) {
        int len = findLen(n); // finding digit length of n. For 135 -> 3, for 1345 -> 4.
        cache = new int[len + 1][2][(1 << 11) - 1];
        for(int i = 0; i <= len; i++){
            Arrays.fill(cache[i][0], -1);
            Arrays.fill(cache[i][1], -1);
        }
        
        digits = new int[len + 1]; // store the digits of num. For 135 -> {5, 3, 1}, for 1354 -> {4, 5, 3, 1}
        int place = 1;
        while(n > 0) {
            digits[place++] = n % 10;
            n /= 10;
        }
        
		// minus 1 to remove the '0' we counted during solve.
        return solve(len, 1, 0) - 1;
    }
    
    private int solve(int place, int tight, int mask) {
        if(place == 0) return 1;
        if(cache[place][tight][mask] != -1) return cache[place][tight][mask];
        
        int count = 0;
        int limit = tight == 1 ? digits[place] : 9;
        for(int i = 0; i <= limit; i++) {
            if(isSet(mask, i)) continue;
			// if i == limit and tight = 1(digit is restricted) -> new_tight = 1
			// mask == 0 && i == 0 ? mask : setBit(mask, i) -> don't set count '0'  as used digit if this is the first digit. 
			//for eg: in 001304, we don't count first 2 '0' as used. But we count the 3rd '0' as used.
            count += solve(place - 1, i == limit && tight == 1 ? 1 : 0, mask == 0 && i == 0 ? mask : setBit(mask, i));
        }
        
        cache[place][tight][mask] = count;
        return count;
    }
    
    private boolean isSet(int mask, int i) {
        return (mask & (1 << i)) != 0;
    }
    
    private int setBit(int mask, int i) {
        return (mask | (1 << i));
    }
    
    private int findLen(int n) {
        int len = 0;
        while(n > 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
