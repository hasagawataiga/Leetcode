package Contest.Contest402;

import java.util.HashMap;
import java.util.Map;

public class Count_pairs_that_form_a_complete_day_ii {
        public long countCompleteDayPairs(int[] hours) {
        long count = 0;
        long[] typeHours = new long[24];
        Map<Integer, Integer> pairs = new HashMap<>();
        pairs.put(1, 23);
        for (int i = 0; i < hours.length; i++) {
            typeHours[hours[i] % 24]++;
        }
        count += typeHours[0] * (typeHours[0] - 1) / 2;
        count += typeHours[12] * (typeHours[12] - 1) / 2;
        for (int i = 1; i < 12; i++) {
            count += typeHours[i] * typeHours[24 - i];
        }
        return count;
    }
}
