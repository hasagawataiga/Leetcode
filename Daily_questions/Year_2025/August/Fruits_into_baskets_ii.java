public class Fruits_into_baskets_ii {
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int fruitIndex = 0;
            int basketIndex = 0;
            List<Integer> basketList = Arrays.stream(baskets).boxed().collect(Collectors.toList());
            int count = 0;
            while (fruitIndex < fruits.length) {
                for (int i = 0; i < basketList.size(); i++) {
                    if (fruits[fruitIndex] <= basketList.get(i)) {
                        basketList.remove(i);
                        count++;
                        break;
                    }
                }
                fruitIndex++;
            }

            return fruits.length - count;
        }
    }
}
