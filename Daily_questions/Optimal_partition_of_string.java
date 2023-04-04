
// Greedy approach
public class Optimal_partition_of_string{
    public int partitionString(String s) {
        int[] set = new int[26];
        int count = 1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (set[ch - 'a'] != 0){
                count++;
                set = new int[26];
            }
            set[ch - 'a']++;
        }
        return count;
    }
}