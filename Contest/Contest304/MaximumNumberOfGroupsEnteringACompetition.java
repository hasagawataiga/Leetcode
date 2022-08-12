import java.util.*;
public class MaximumNumberOfGroupsEnteringACompetition {
    //My solution is that 1st group has 1 student, 2nd group has 2 students, 3rd group has 3 students, ...
    //I assumpt that the array of grades is ascending ordered
    //For example, we have 10 students then It should be grouped to 1,2,3,4
    //Applying function for the sum of increasing number: n(n+1)/2 = sum
    //Explain the formula used:
    //n^2 + n - 2*sum = 0
    //n = (-b + sqrt(b*b - 4*a*c))/2/a
    //n = (-b - sqrt(b*b - 4*a*c))/2/a (this is ignored because we only need the greater root)
    // => n = (-1 + sqrt(1 + 8*sum))/2
    public int calculation(int[] grades){
        int students = grades.length;
        double groups = (-1 + Math.sqrt(1 + 8*students))/2;
        return (int)groups;
    }
}
