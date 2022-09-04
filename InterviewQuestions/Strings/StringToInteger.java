package InterviewQuestions.Strings;

import java.util.*;
public class StringToInteger {
    public int myAtoi (String s){
        int charBeginIndex = 0;
        int length = s.length();
        int number = 0;
        int sign = 1;
        char ch = s.charAt(charBeginIndex);
        ArrayList<Character> list = new ArrayList<Character>();
        while (charBeginIndex < length){
            ch = s.charAt(charBeginIndex);
            if(ch > 47 && ch < 58){
                list.add(ch);
            }
            charBeginIndex++;
            if(ch == '-'){sign = -1;}
        }
        for(int i = charBeginIndex; i < length; i++){
            number = number*10 + (list.get(i) - '0');
        }
        return number*sign;
    }
}
