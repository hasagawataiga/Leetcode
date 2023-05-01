public class Average_salary_excluding_minimum_and_maximum_salary {
    public double average(int[] salary) {
        int sum = 0;
        int max = salary[0];
        int min = salary[0];
        for (int i = 0; i < salary.length; i++){
            if (max < salary[i]){
                max = salary[i];
            }
            if (min > salary[i]){
                min = salary[i];
            }
            sum += salary[i];
        }
        double average = (double) (sum - max - min)/(salary.length - 2); // Cast to double before dividing
        if (max != min){
            return average;
        } else {
            return 0;
        }
    }
}
