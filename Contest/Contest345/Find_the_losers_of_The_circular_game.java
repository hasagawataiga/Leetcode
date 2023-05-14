package Contest.Contest345;

public class Find_the_losers_of_The_circular_game {
    public int[] circularGameLosers(int n, int k) {
        int[] players = new int[n];
        players[0] = 1;
        boolean isEnd = false;
        int step = 0;
        int player = 0;
        while (!isEnd){
            step++;
            player += step * k;
            player %= n;
            if (players[player] == 1){
                isEnd = true;
            }
            players[player]++;
        }
        if (n <= step){
            return new int[0];
        }
        int[] res = new int[n - step];
        int index = 0;
        for (int i = 1; i < n; i++){
            if (players[i] == 0){
                res[index] = i + 1;
                index++;
            }
        }
        return res;
    }
}
