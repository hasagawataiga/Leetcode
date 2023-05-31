import java.util.HashMap;
import java.util.Map;



// Table approach (hashmap, map)
// Using 2 map:
//      1. store the startStation and startTime
//      2. store the endStation and endTime for the travel
public class Design_underground_system {
    class UndergroundSystem {
        class CheckIn{
            String startStation;
            double time;
            public CheckIn(String startStation, double time){
                this.startStation = startStation;
                this.time = time;
            }
            public String getStation(){
                return this.startStation;
            }
            public double getTime(){
                return this.time;
            }
        }
        Map<Integer, CheckIn> checkIns;
        Map<String, Map<String, double[]>> checkOuts;
        public UndergroundSystem() {
            checkIns = new HashMap<>();
            checkOuts = new HashMap<>();
        }
        
        public void checkIn(int id, String stationName, int t) {
            checkIns.put(id, new CheckIn(stationName, (double)t));
        }
        
        public void checkOut(int id, String stationName, int t) {
            String startStation = checkIns.get(id).getStation();
            double startTime = checkIns.get(id).getTime();
            double duration = (double)t - startTime;
            checkOuts.putIfAbsent(startStation, new HashMap<>());
            checkOuts.get(startStation).putIfAbsent(stationName, new double[2]);
            checkOuts.get(startStation).get(stationName)[0] += duration;
            checkOuts.get(startStation).get(stationName)[1]++;
        }
        
        public double getAverageTime(String startStation, String endStation) {
            double average = checkOuts.get(startStation).get(endStation)[0] / checkOuts.get(startStation).get(endStation)[1];   
            return average;     
        }
    }
    
    /**
     * Your UndergroundSystem object will be instantiated and called as such:
     * UndergroundSystem obj = new UndergroundSystem();
     * obj.checkIn(id,stationName,t);
     * obj.checkOut(id,stationName,t);
     * double param_3 = obj.getAverageTime(startStation,endStation);
     */
}
