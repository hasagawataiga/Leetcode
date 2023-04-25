


public class Smallest_number_in_infinite_set {
    class SmallestInfiniteSet {
        int min;
        int[] set;
        public SmallestInfiniteSet() {
            min = 1;
            set = new int[1001];
        }
        
        public int popSmallest() {
            int res = 1;
            for (int i = 1; i < 1001; i++){
                if (set[i] == 0){
                    res = i;
                    set[i] = 1;
                    break;
                }
            }
            return res;
        }
        
        public void addBack(int num) {
            if (set[num] == 1){
                set[num] = 0;
            }
        }
    }
}
