import java.util.ArrayList;
import java.util.List;

public class Lexicographical_numbers {
    class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> list = new ArrayList<>();

            for (int i = 1; i < 10; i++) {
                dfs(list, i, n);
            }
            return list;
        }

        private void dfs(List<Integer> list, int stage, int num) {
            if (stage > num) {
                return;
            }

            list.add(stage);
            for (int i = 0; i < 10; i++) {
                dfs(list, stage * 10 + i, num);
            }
        }
    }
}