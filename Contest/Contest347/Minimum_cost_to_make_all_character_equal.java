package Contest.Contest347;


// Greedy Approach
public class Minimum_cost_to_make_all_character_equal {
    public long minimumCost(String s) {
        long cost = 0;
        int n = s.length();
        for (int i = 1; i < n; i++){
            if (s.charAt(i) != s.charAt(i - 1)){
                cost += Math.min(i, n - i);
            }
        }
        return cost;
    }
}
