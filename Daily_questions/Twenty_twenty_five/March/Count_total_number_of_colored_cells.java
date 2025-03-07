package Daily_questions.Twenty_twenty_five.March;

public class Count_total_number_of_colored_cells {
    class Solution {
        public long coloredCells(int n) {
    
            int lengthOfBase = 2 * n - 1;
    
            return 2 * totalCells(lengthOfBase) - lengthOfBase;
            // return totalCells(n) - totalCells(n - 1);
        }
    
        private long totalCells(int n) {
            long sum = 0;
    
            for (int i = n; i > 0; i-=2) {
                sum += i;
            }
    
            return sum;
        }
    }
}
