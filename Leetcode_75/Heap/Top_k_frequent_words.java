package Leetcode_75.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_k_frequent_words {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < k; i++){
            res.add(findAndRemoveMax(map));
        }
        return res;
    }
    private String findAndRemoveMax(HashMap<String, Integer> map){
        String maxStr = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            String key = entry.getKey();
            if (max < val){
                max = val;
                maxStr = key;
            } else if (max == val){
                if (maxStr.compareTo(key) > 0){
                    maxStr = key;
                }
            }
        }
        map.remove(maxStr);
        return max
}
