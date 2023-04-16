package Contest.Contest341;

public class Find_the_maximum_divisibility_score {
    public int maxDivScore(int[] nums, int[] divisors) {
        int max = Integer.MIN_VALUE;
        int res = divisors[0];
        int[] count = new int[divisors.length];
        for (int i = 0; i < divisors.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (nums[j] % divisors[i] == 0){
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < count.length; i++){
            if (max < count[i]){
                max = count[i];
                res = divisors[i];
            } else if (max == count[i] && res > divisors[i]){
                res = divisors[i];
            }
        }
        return res;
    }
}
