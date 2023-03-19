package Programming_skills_plan.Programming_skills_I;

public class Count_odd_numbers_in_an_interval_range {
    public int countOdds(int low, int high) {
        int odd = 0;
        odd = (high - low)/2;
        if (low%2 == 1 || high%2 == 1){
            odd++;
        }
        return odd;
    }
}
