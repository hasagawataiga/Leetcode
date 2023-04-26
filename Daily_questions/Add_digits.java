

public class Add_digits{
    public int addDigits(int num) {
        while (num > 9){
            int temp = num;
            num = 0;
            while (temp != 0){
                int digit = temp%10;
                temp /= 10;
                num += digit;
            }
        }
        return num;
    }
}