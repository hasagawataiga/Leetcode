public class Final_value_of_variable_after_performing_operations {
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int res = 0;
            for (String operation : operations) {
                if (operation.equals("--X") || operation.equals("X--")) {
                    res--;
                } else {
                    res++;
                }
            }

            return res;
        }
    }
}
