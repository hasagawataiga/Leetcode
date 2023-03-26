package Contest.Contest338;

public class K_items_with_the_maximum_sum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0){
            return 0;
        }
        int sum = 0;
        if (k <= numOnes){
            return k;
        } else if (k > numOnes && k <= (numZeros + numOnes)){
            return numOnes;
        } else if (k > (numZeros + numOnes)){
            return numOnes - (k - numOnes - numZeros);
        }
        return sum;
    }
}

