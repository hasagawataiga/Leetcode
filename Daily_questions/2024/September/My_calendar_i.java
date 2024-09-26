import java.util.ArrayList;
import java.util.List;

public class My_calendar_i {
    class MyCalendar {
        List<int[]> intervals;
    
        public MyCalendar() {
            intervals = new ArrayList<>();
        }
    
        public boolean book(int start, int end) {
            // Check for overlap with existing intervals
            for (int[] interval : intervals) {
                int existingStart = interval[0];
                int existingEnd = interval[1];
    
                // Overlap occurs if the new event does not completely end before
                // the existing event starts, or completely start after the existing event ends.
                if (Math.max(start, existingStart) < Math.min(end, existingEnd)) {
                    return false;  // Overlap detected
                }
            }
    
            // No overlap, so we can book the event
            intervals.add(new int[]{start, end});
            return true;
        }
    }
}
