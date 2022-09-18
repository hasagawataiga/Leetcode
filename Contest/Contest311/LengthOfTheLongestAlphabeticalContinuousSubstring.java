package Contest.Contest311;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s){
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            int temp = 1;
            int j = i;
            while(j+1 < s.length()){
                if(s.charAt(j) != s.charAt(j+1) + 1){
                    break;
                }
                j++;
                temp++;
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}
