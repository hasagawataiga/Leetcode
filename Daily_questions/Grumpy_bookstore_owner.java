public class Grumpy_bookstore_owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int right = left + minutes;
        int maxCustomersInGrumpy = 0;
        int maxIndex = -1;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                maxCustomersInGrumpy += customers[i];
                maxIndex = 0;
            }
        }
        // Find the max customers in grumpy period interval
        int currentInterval = maxCustomersInGrumpy;
        while (right < customers.length) {
            if (grumpy[left] == 1) {
                currentInterval -= customers[left];
            }
            if (grumpy[right] == 1) {
                currentInterval += customers[right];
            }
            left++;
            if (maxCustomersInGrumpy < currentInterval) {
                maxCustomersInGrumpy = currentInterval;
                maxIndex = left;
            }
            right++;
        }
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i >= maxIndex && i < maxIndex + minutes) {
                sum += customers[i];
            } else {
                if (grumpy[i] == 0) {
                    sum += customers[i];
                }
            }
        }
        return sum;
    }
}
