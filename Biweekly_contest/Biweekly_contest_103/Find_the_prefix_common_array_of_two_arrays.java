package Biweekly_contest.Biweekly_contest_103;


// Medium
public class Find_the_prefix_common_array_of_two_arrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] a = new int[51];
        int[] b = new int[51];
        for (int i = 0; i < n; i++){
            a[A[i]]++;
            b[B[i]]++;
            res[i] = countEqual(a, b);
        }
        return res;
    }
    private int countEqual(int[] a, int[] b){
        int count = 0;
        for (int i = 0; i < 51; i++){
            if (a[i] != 0 && a[i] == b[i]){
                count++;
            }
        }
        return count;
    }
}
