package Leetcode_75.Array_string;

public class Reverse_words_in_a_string {
    // private void print(String[] strs){
    //     for (String str : strs){
    //         System.out.print(str + ",");
    //     }
    //     System.out.println();
    // }
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int n = strs.length;
        // System.out.println(n);
        // print(strs);
        int left = 0;
        int right = n - 1;
        while (left < right){
            if (strs[left].isEmpty()){
                left++;
                continue;
            }
            if (strs[right].isEmpty()){
                right--;
                continue;
            }
            swap(strs, left, right);
            left++;
            right--;
            // System.out.println(left + "," + right);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++){
            if (strs[i].isEmpty()){
                continue;
            }
            sb.append(strs[i]);
            sb.append(" ");
        }
        sb.append(strs[n - 1]);
        return sb.toString();
    }
    private void swap(String[] strs, int a, int b){
        String temp = strs[a];
        strs[a] = strs[b];
        strs[b] = temp;
    }
}
