public class Remove_trailing_zeros_from_a_string {
    public String removeTrailingZeros(String num) {
        int index = num.length() - 1;
        while (index >= 0){
            int digit = num.charAt(index) - '0';
            if (digit != 0){
                break;
            } else {
                index--;
            }
        }
        return num.substring(0, index + 1);
    }
}
