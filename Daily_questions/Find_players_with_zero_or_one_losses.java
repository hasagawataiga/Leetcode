import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Find_players_with_zero_or_one_losses {
        Set<Integer> players = new HashSet<>();
    List<Integer> noLoss = new ArrayList<>();
    List<Integer> oneLoss = new ArrayList<>();
    Set<Integer> others = new HashSet<>();
    public List<List<Integer>> findWinners(int[][] matches) {
        players.add(matches[0][0]);
        players.add(matches[0][1]);
        traversal(matches, 1, matches[0][0], 0);
        traversal(matches, 1, matches[0][1], 1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(noLoss.stream().sorted().collect(Collectors.toList()));
        res.add(oneLoss.stream().sorted().collect(Collectors.toList()));
        return res;
    }

    private void traversal(int[][] matches, int matchIndex, int player, int losses) {
        if (losses > 1) {
            return;
        }
        if (matchIndex == matches.length) {
            if (losses == 0) {
                noLoss.add(player);
            } else {
                oneLoss.add(player);
            }
            return;
        }
        int winner = matches[matchIndex][0];
        int loser = matches[matchIndex][1];
        if (winner == player) {
            traversal(matches, matchIndex + 1, player, losses);
        } else if (players.add(winner)) {
            traversal(matches, matchIndex + 1, winner, 0);
        }
        if (loser == player) {
            traversal(matches, matchIndex + 1, player, losses + 1);
        } else if (players.add(loser)) {
            traversal(matches, matchIndex + 1, loser, 1);
        }
    }
}
