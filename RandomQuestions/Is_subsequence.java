package RandomQuestions;

public class Is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS == 0){
            return true;
        }
        if (lengthS > lengthT){
            return false;
        }
        int count = 0;
        for (int i = 0; i < lengthT; i++){
            if (s.charAt(count) == t.charAt(i)){
                count++;
            }
            if (count == lengthS){
                return true;
            }
        }
        return false;
    }
}
