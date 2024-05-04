import java.util.Arrays;

// Two pointers approach
public class Boats_to_save_people {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int left = 0;
        int right = people.length - 1;
        while (left < right){
            if (people[left] + people[right] <= limit){
                min++;
                left++;
                right--;
            } else {
                min++;
                right--;
            }
        }
        if (left == right){
            min++;
        }
        return min;
    }
    // Another Approach
    
    // public int numRescueBoats(int[] people, int limit) {
    //     Arrays.sort(people);
    //     int min = 0;
    //     int smallest = 0;
    //     for (int i = people.length - 1; i >= 0; i--) {
    //         if (i >= smallest) {
    //             if ((people[i] + people[smallest]) <= limit) {
    //                 smallest++;
    //             }
    //             min++;
    //         }
    //     }
    //     return min;
    // }
}
