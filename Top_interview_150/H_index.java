package Top_interview_150;

public class H_index {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int res = 0;
        int[] citationsCount = new int[n + 1];
        for (int citation : citations){
            citationsCount[Math.min(n, citation)]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--){
            count += citationsCount[i];
            if (count >= i){
                res = i;
                break;
            }
        }
        return res;
    }
}
