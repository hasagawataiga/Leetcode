public class Reverse_integer {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        double res = 0.0;
        while (x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > max || res < min){
            return 0;
        }
        return (int)res;
    }
}
