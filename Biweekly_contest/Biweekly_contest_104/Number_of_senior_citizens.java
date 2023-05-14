package Biweekly_contest.Biweekly_contest_104;

public class Number_of_senior_citizens {
    public int countSeniors(String[] details) {
        int res = 0;
        for (int i = 0; i < details.length; i++){
            String ageStr = details[i].substring(11, 13);
            int age = Integer.parseInt(ageStr);
            if (age > 60){
                res++;
            }
        }
        return res;
    }
}
