package interview_questions.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            String temp;
            if (i % 15 == 0){
                temp = "FizzBuzz";
            } else if (i % 3 == 0){
                temp = "Fizz";
            } else if (i % 5 == 0){
                temp = "Buzz";
            } else {
                // Remember that prefer to use Integer.toString(i) instead of i + ""
                //  because of the efficienty
                temp = Integer.toString(i);
            }
            list.add(temp);
        }
        return list;
    }
}
