package Leetcode_75.Queue;




public class Dota2_senate {
    public String predictPartyVictory(String senate) {
        char[] senateChars = senate.toCharArray();
        int n = senateChars.length;
        int rCount = 0;
        int dCount = 0;
        for (char ch : senateChars){
            if (ch == 'R'){
                rCount++;
            } else {
                dCount++;
            }
        }
        int index = 0;
        String res = "";
        while (rCount != 0 || dCount != 0){
            if (senateChars[index] == 'R'){
                if (!banNearestOpponent(senateChars, index, 'D')){
                    res = "Radiant";
                    return res;
                } else {
                    dCount--;
                }
            } else if (senateChars[index] == 'D'){
                if (!banNearestOpponent(senateChars, index, 'R')){
                    res = "Dire";
                    return res;
                } else {
                    rCount--;
                }
            }
            index++;
            index %= n;
        }
        return res;
    }
    private boolean banNearestOpponent(char[] senateChars, int index, char opponent){
        for (int i = index + 1; i < senateChars.length; i++){
            if (senateChars[i] == opponent){
                senateChars[i] = 'X';
                return true;
            }
        }
        for (int i = 0; i < index; i++){
            if (senateChars[i] == opponent){
                senateChars[i] = 'X';
                return true;
            }
        }
        return false;
    }
}
