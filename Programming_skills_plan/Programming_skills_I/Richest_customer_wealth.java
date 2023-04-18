package Programming_skills_plan.Programming_skills_I;

public class Richest_customer_wealth {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++){
            int sum = accounts[i][0];
            for (int j = 1; j < accounts[i].length; j++){
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
