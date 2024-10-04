public class Divide_players_into_teams_of_equal_skill {
    class Solution {
        public long dividePlayers(int[] skill) {
            Arrays.sort(skill);
            long sum = 0;
            int n = skill.length;
            int prevSum = skill[0] + skill[n - 1];
            for (int i = 0; i < n / 2; i++) {
                int currSum = skill[i] + skill[n - i - 1];
                if (currSum != prevSum) {
                   return -1;
                }
                sum += skill[i] * skill[n - i - 1];
            } 
            return sum;
        }
    }
}
