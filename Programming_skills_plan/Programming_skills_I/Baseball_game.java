package Programming_skills_plan.Programming_skills_I;

public class Baseball_game {
    public int calPoints(String[] operations) {
        int sum = 0;
        int index = 0;
        int[] records = new int[1000];
        for (int i = 0; i < operations.length; i++){
            String str = operations[i];
            if (str.equals("+")){
                records[index] = records[index - 1] + records[index - 2];
            } else if (str.equals("D")){
                records[index] = 2 * records[index - 1];
            } else if (str.equals("C")){
                index--;
                continue;
            } else {
                records[index] = Integer.parseInt(str);
            }
            index++;
        }
        for (int i = 0; i < index; i++){
            sum += records[i];
        }
        return sum;
    }
}
