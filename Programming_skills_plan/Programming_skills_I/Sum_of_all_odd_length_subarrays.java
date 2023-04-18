package Programming_skills_plan.Programming_skills_I;


// Sliding Window approach
public class Sum_of_all_odd_length_subarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int currSum = 0;
        int lo = 0;
        int hi = 0;
        int length = arr.length;
        for (int i = 1; i <= length; i += 2){
            lo = 0;
            hi = 0;
            currSum = 0;
            while (hi - lo < i){
                currSum += arr[hi];
                hi++;
            }
            sum += currSum;
            while (hi < length){
                currSum -= arr[lo];
                lo++;
                currSum += arr[hi];
                hi++;
                sum += currSum;
            }
        }
        return sum;
    }
}
