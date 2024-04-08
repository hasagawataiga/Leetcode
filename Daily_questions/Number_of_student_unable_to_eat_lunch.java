public class Number_of_student_unable_to_eat_lunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int circularSandwichCount = 0;
        int squareSandwichCount = 0;
        for (int student : students) {
            if (student == 1) {
                squareSandwichCount++;
            } else {
                circularSandwichCount++;
            }
        }
        for (int sandwich : sandwiches) {
            if (sandwich == 1 && squareSandwichCount > 0) {
                squareSandwichCount--;
            } else if (sandwich == 0 && circularSandwichCount > 0) {
                circularSandwichCount--;
            } else {
                return squareSandwichCount + circularSandwichCount;
            }
        }
        return 0;
    }
}
