public class Relative_ranks {
    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        String[] ans = new String[length];
        int[][] positionWithScore = new int[length][2];
        for (int i = 0; i < length; i++) {
            positionWithScore[i][0] = score[i];
            positionWithScore[i][1] = i;
        }
        Arrays.sort(positionWithScore, (b, a) -> Integer.compare(a[0], b[0]));
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                ans[positionWithScore[i][1]] = "Gold Medal";
            } else if (i == 1) {
                ans[positionWithScore[i][1]] = "Silver Medal";
            } else if (i == 2) {
                ans[positionWithScore[i][1]] = "Bronze Medal";
            } else {
                ans[positionWithScore[i][1]] = i + 1 + "";
            }
        }
        return ans;
    }
}