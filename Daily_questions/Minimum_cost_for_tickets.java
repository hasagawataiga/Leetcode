public class Minimum_cost_for_tickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[396];
        boolean[] travelDays = new boolean[396];

        // Mark the travel days
        for (int day : days) {
            travelDays[day] = true;
        }

        // Start from the last day and work backward
        for (int i = 365; i >= 1; i--) {
            if (!travelDays[i]) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.min(costs[0] + dp[i+1], Math.min(costs[1] + dp[i+7], costs[2] + dp[i+30]));
            }
        }

        return dp[1];

    }
}
