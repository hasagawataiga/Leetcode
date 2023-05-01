package Top_interview_150;

import java.util.Arrays;

public class H_index {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int res = 0;
        for (int i = 0; i < n; i++){
            int papers = n - i;
            if (citations[i] >= papers){
                res = papers;
                break;
            }
        }
        return res;
    }
}
