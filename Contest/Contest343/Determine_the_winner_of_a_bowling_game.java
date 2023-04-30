package Contest.Contest343;


// Easy
public class Determine_the_winner_of_a_bowling_game {
    public int isWinner(int[] player1, int[] player2) {
        int count1 = 0;
        int count2 = 0;
        int score1 = 0;
        int score2 = 0;
        for (int i = 0; i < player1.length; i++){
            if (count1 > 0){
                score1 += player1[i] * 2;
                count1--;
            } else if (count1 == 0){
                score1 += player1[i];
            }
            if (count2 > 0){
                score2 += player2[i] * 2;
                count2--;
            } else if (count2 == 0){
                score2 += player2[i];
            }
            if (player1[i] == 10){
                count1 = 2;
            }
            if (player2[i] == 10){
                count2 = 2;
            }
        }
        int res = score1 - score2;
        if (res > 0){
            return 1;
        } else if (res < 0){
            return 2;
        } else {
            return 0;
        }
    }
}
