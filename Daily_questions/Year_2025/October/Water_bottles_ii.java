package Daily_questions.Year_2025.October;

public class Water_bottles_ii {
    class Solution {
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int bottlesDrunk = 0;
            Bottles container = new Bottles(numBottles);
            while (container.fulls > 0 || container.empties >= numExchange) {
                if (container.empties >= numExchange) {
                    container.exchange(numExchange++);
                } else {
                    bottlesDrunk += container.fulls;
                    container.drink();
                }
            }

            return bottlesDrunk;
        }
    }

    class Bottles {
        int fulls;
        int empties;
        public Bottles(int n) {
            this.fulls = n;
        }

        public void drink() {
            this.empties += fulls;
            fulls = 0;
        }

        public void exchange(int numExchange) {
            empties -= numExchange;
            fulls++;
        }
    }
}
