package Programming_skills_plan.Programming_skills_I;

// Find the difference via formula: (max - min) / (length - 1)
// Iterating over the array and check if the 
//      (arr[i] - min) / diff == i
//  if ==, continue to the next element
//  if !=, check whether the the proper position of arr[i] has had arr[i] yet? 
//                      if yes, it means that the arr[i] appeared more than once, return false;
//                      if no, swap arr[i] to the elements at arr[i] should be.

public class Can_make_arithmetic_progression_from_sequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int length = arr.length;
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        // Return true in the case all the elements are equals to each other.
        if (max == min){
            return true;
        }
        if ((max - min)%(length - 1) != 0){
            return false;
        }
        int diff = (max - min)/(length - 1);
        int i = 0;
        while (i < length){
            if ((arr[i] - min)%diff != 0){
                return false;
            } else {
                int j = (arr[i] - min)/diff;
                if (i == j){
                    i++;
                    continue;
                } else if (arr[i] == arr[j]){
                    return false;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }       
            }
        }
        return true;
    }
}
