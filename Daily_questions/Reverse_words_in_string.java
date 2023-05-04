public class Reverse_words_in_string {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        int n = strs.length;
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
