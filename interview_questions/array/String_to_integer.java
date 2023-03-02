public class String_to_integer {
    public int myAtoi(String s) {
        int index = 0;
        if (s.length() == 0){
            return 0;
        }
        // Ignore space
        while (s.charAt(index) == ' '){
            index++;
            if (index >= s.length()){
                return 0;
            }
        }

        // Check the sign of number
        boolean isNegative = false;
        if (s.charAt(index) == '-'){
            index++;
            isNegative = true;
        } else {
            isNegative = false;
            if (s.charAt(index) == '+'){
                index++;
            }
        }
        // Get the digits if it is existed
        double doubleNumber = 0;
        while ( index < s.length() && s.charAt(index) <= '9' && s.charAt(index) >= '0'){
            int temp = s.charAt(index) - '0';
            doubleNumber = doubleNumber * 10 + temp;
            index++;
        }
        // Use double type to store the value of String converted preventing the out of range of Integer
        if (isNegative){
            doubleNumber = -doubleNumber;
        }
        if (doubleNumber > Integer.MAX_VALUE){
            doubleNumber = Integer.MAX_VALUE;
        } else if (doubleNumber < Integer.MIN_VALUE){
            doubleNumber = Integer.MIN_VALUE;
        }
        return (int)doubleNumber;
    }
}
