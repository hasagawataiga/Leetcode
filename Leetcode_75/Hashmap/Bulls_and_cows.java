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
            cows += Math.min(secretCount[i], guessCount[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
