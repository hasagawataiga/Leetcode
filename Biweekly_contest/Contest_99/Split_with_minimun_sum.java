package Biweekly_contest.Contest_99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Split_with_minimun_sum {
    public int splitNum(int num) {
        List<Integer> container = new ArrayList<>();
        while (num != 0){
            container.add(num%10);
            num = num/10;
        }
        int index = 0;
        int number1 = 0;
        int number2 = 0;
        Collections.sort(container);
        while (index < container.size()){
            int element = container.get(index);
            number1 = number1*10 + element;
            index += 2;
        }
        index = 1;
        while (index < container.size()){
            int element = container.get(index);
            number2 = number2*10 + element;
            index += 2;
        }
        return number1 + number2;
    }
}
