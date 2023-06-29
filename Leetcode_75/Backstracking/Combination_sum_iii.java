package Leetcode_75.Backstracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_sum_iii {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combination(k, n, 1, new ArrayList<>(), list);
        return list;
    }
    private void combination(int k, int n, int index, List<Integer> curr, List<List<Integer>> list){
        if (k == 0 && n == 0){
            list.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= 9; i++){
            curr.add(i);
            combination(k - 1, n - i, i + 1, curr, list);
            curr.remove(curr.size() - 1);
        }
    }
}
