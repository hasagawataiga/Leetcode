public class Roman_to_number {
    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int number = 0;
        for (int i = 0; i < charArray.length; i++){
            if (charArray[i] == 'I'){
                if (i+1 < length && charArray[i+1] == 'V'){
                    number += 4;
                    i++;
                } else if (i+1 < length && charArray[i+1] == 'X'){
                    number += 9;
                    i++;
                } else {
                    number += 1;
                }
            } else if (charArray[i] == 'X'){
                if (i+1 < length && charArray[i+1] == 'L'){
                    number += 40;
                    i++;
                } else if (i+1 < length && charArray[i+1] == 'C'){
                    number += 90;
                    i++;
                } else {
                    number += 10;
                }
            } else if (charArray[i] == 'C'){
                if (i+1 < length && charArray[i+1] == 'D'){
                    number += 400;
                    i++;
                } else if (i+1 < length && charArray[i+1] == 'M'){
                    number += 900;
                    i++;
                } else {
                    number += 100;
                }
            } else if (charArray[i] == 'V'){
                number += 5;
            } else if (charArray[i] == 'L'){
                number += 50;
            } else if (charArray[i] == 'D'){
                number += 500;
            } else {
                number += 1000;
            }
            
        }
        return number;
    }g
}
