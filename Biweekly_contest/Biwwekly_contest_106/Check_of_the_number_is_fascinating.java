package Biweekly_contest.Biwwekly_contest_106;

public class Check_of_the_number_is_fascinating {
    public boolean isFascinating(int n) {
        int[] numbers = new int[10];
        int doubleNum = 2 * n;
        int tripleNum = 3 * n;
        while (n != 0 || doubleNum != 0 || tripleNum != 0){
            numbers[n % 10]++;
            numbers[doubleNum % 10]++;
            numbers[tripleNum % 10]++;
            n /= 10;
            doubleNum /= 10;
            tripleNum /= 10;
        }
        if (numbers[0] != 0){
            return false;
        }
        for (int i = 1; i < 10; i++){
            if (numbers[i] == 0){
                return false;
            }
        }
        return true;
    }
}
