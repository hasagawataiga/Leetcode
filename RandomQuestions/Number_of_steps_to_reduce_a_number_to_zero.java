package RandomQuestions;

public class Number_of_steps_to_reduce_a_number_to_zero {
    public int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0){
            steps++;
            if (num%2 == 0){
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return steps;
    }
}
