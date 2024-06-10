public class Height_checker {
    public int heightChecker(int[] heights) {
        int[] corrected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(corrected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != corrected[i]) {
                count++;
            }
        }
        return count;
    }
}
