public class Number_of_student_unable_to_eat_lunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }
        int sandwichIndex = 0;
        int studentIndex = 0;
        while (!queue.isEmpty() && sandwichIndex < sandwiches.length) {
            int size = queue.size();
            boolean edible = false;
            for (int i = 0; i < size; i++) {
                int firstGuy = queue.poll();
                if (firstGuy == sandwiches[sandwichIndex]) {
                    sandwichIndex++;
                    edible = true;
                } else {
                    queue.offer(firstGuy);
                }
            }
            if (!edible) {
                return queue.size();
            }
            studentIndex++;
        }
        return 0;
    }
}
