public class Minimum_time_difference {
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            boolean[][] times = new boolean[24][60];
            for (String timePoint : timePoints) {
                String[] splitTime = timePoint.split(":");
                int hour = Integer.parseInt(splitTime[0]);
                int minute = Integer.parseInt(splitTime[1]);
                if (times[hour][minute]) {
                    return 0;
                } else {
                    times[hour][minute] = true;
                }
            }
            int min = 24 * 60 + 1;
            int firstTime = min;
            int prev = -24 * 60;
            for (int i = 0; i < 24; i++) {
                for (int j = 0; j < 60; j++) {
                    if (times[i][j]) {
                        if (firstTime > (23 * 60 + 59)) {
                            firstTime = i * 60 + j;
                        }
                        min = Math.min(min, i * 60 + j - prev);
                        min = Math.min(min, 24 * 60 - i * 60 - j + firstTime);
                        prev = i * 60 + j;
                    }
                }
            }
            return min;
        }
    }
}