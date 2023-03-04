package Biweekly_contest.Contest_99;

public class Count_total_number_of_colored_cells {
    public long coloredCells(int n) {
        // Consider it likes a 2-d pyramid which inflates to both side (above and below)
        // The general formula for this pyramids is: 2n^2 - 2n + 1
        long powed = (long)Math.pow(n, 2);
        return 2*powed- 2*n + 1;
    }
}
