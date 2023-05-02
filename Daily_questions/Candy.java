import java.util.Arrays;


// Two arrays left to right and right to left
// Divide the rules of problem into 2 parts:
//      1. if the rating of i-th element is greater than the (i - 1)-th, the candies of i-th is equal to the value of (i - 1)-th + 1
//      2. if the rating of i-th element is greater than the (i + 1)-th, the candies of i-th is equal to the value of (i + 1)-th + 1
// Finally, take the higher value of those arrays, it is always satisfied the rules of problem.
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++){
            if (ratings[i] > ratings[i - 1]){
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--){
            if (ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int candy : candies){
            sum += candy;
        }
        return sum;
    }
}