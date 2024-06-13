public class Minimum_number_of_moves_to_seat_everyone {
    int length;
    int[] order;
    public int minMovesToSeat(int[] seats, int[] students) {
        length = seats.length;
        order = new int[101];
        for (int i = 0; i < length; i++) {
            order[seats[i]]--;
            order[students[i]]++;
        }
        int emptySeat = nextEmptySeat(seats, 0);
        int student = nextStudent(students, 0);
        int count = 0;
        while (emptySeat < 101) {
            count += Math.abs(emptySeat - student);
            if (++order[emptySeat] == 0) {
                emptySeat = nextEmptySeat(seats, emptySeat);
            }
            if (--order[student] == 0) {
                student = nextStudent(students, student);
            }
        }
        return count;
    }
    private int nextEmptySeat(int[] seats, int current) {
        int i = current;
        for (; i < 101; i++) {
            if (order[i] < 0) {
                return i;
            }
        }
        return i;
    }
    private int nextStudent(int[] students, int current) {
        int i = current;
        for (; i < 101; i++) {
            if (order[i] > 0) {
                return i;
            }
        }
        return i;
    }
}