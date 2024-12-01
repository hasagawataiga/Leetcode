public class Check_if_n_and_its_double_exist {
    class Solution {
        public boolean checkIfExist(int[] arr) {
            boolean[] valRange = new boolean[4001];
            for (int i = 0; i < arr.length; i++) {
                if (valRange[arr[i] + 2000]) {
                    return true;
                }
                valRange[2 * arr[i] + 2000] = true;
                if (arr[i] % 2 == 0) {
                    valRange[arr[i] / 2 + 2000] = true;
                }
            }
    
            return false;
        }
    }
}
