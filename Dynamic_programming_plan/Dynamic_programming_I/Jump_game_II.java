package Dynamic_programming_plan.Dynamic_programming_I;

public class Jump_game_II {
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++)
        {    int min=Integer.MAX_VALUE;
            for(int j=i-1;j>-1;j--)
            {
                if(nums[j]+j>=i)
                min=Math.min(min,dp[j]);
            }
            dp[i]=min+1;
        }
        return dp[n-1]-1;
     }
}
