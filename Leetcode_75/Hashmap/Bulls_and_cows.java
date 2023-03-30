package Leetcode_75.Hashmap;

public class Bulls_and_cows {
    public String getHint(String secret, String guess) {
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        char[] secretChars = secret.toCharArray();
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secretChars.length; i++){
            if (secretChars[i] == guess.charAt(i)){
                bulls++;
            } else {
                secretCount[secretChars[i] - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < secretCount.length; i++){
            if (secretCount[i] == 0 || guessCount[i] == 0){
                continue;
            }
            if (secretCount[i] == guessCount[i]){
                cows += secretCount[i];
            } else if (secretCount[i] > guessCount[i]){
                cows += guessCount[i];
            } else {
                cows += secretCount[i];
            }
        }
        return bulls + "A" + cows + "B";
    }
}
