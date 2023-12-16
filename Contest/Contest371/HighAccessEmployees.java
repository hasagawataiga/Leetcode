package Contest.Contest371;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighAccessEmployees {
        public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> access_time : access_times) {
            map.putIfAbsent(access_time.get(0), new ArrayList<>());
            map.get(access_time.get(0)).add(access_time.get(1));
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() < 3){
                continue;
            }
            if (isValid(entry.getValue())) {
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
    private boolean isValid(List<String> access) {
        Collections.sort(access);
        for (int i = 2; i < access.size(); i++) {
            if (inOneHour(access.get(i - 2), access.get(i))) {
                return true;
            }
        }
        return false;
    }
    private boolean inOneHour(String start, String end) {
        int hour = Integer.parseInt(end.substring(0, 2)) - Integer.parseInt(start.substring(0, 2));
        if (hour == 0) {
            return true;
        } else if (hour == 1) {
            if (end.substring(2, 4).compareTo(start.substring(2, 4)) < 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
