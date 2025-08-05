public class Fruits_into_baskets_ii {
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int count = 0;
            int length = fruits.length;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (fruits[i] <= baskets[j]) {
                        baskets[j] = 0;
                        count++;
                        break;
                    }
                }
            }

            return fruits.length - count;
        }
    }
}
