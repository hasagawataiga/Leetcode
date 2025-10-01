package Daily_questions.Year_2025.October;

class Water_bottles {
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int emptyBottles = 0;
            int drankTimes = 0;
            while ((numBottles + emptyBottles) >= numExchange) {
                drankTimes += numBottles;
                emptyBottles += numBottles;
                numBottles = emptyBottles / numExchange;
                emptyBottles = emptyBottles % numExchange;
            }

            return drankTimes + numBottles;
        }
    }
}