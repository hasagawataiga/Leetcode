public class Maximize_the_confusion_of_an_exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int trues = 0;
        int falses = 0;
        int n = answerKey.length();
        if (n == k){
            return n;
        }
        if (n == 2){
            if (answerKey.charAt(0) != answerKey.charAt(1)){
                if (k > 0){
                    return 2;
                } else {
                    return 1;
                }
            } else {
                return 2;
            }
        }
        int[] mins = new int[n];
        for (int i = 0; i < n; i++){
            char ch = answerKey.charAt(i);
            if (ch == 'T'){
                trues++;
            } else {
                falses++;
            }
            mins[i] = Math.min(trues, falses);
        }
        int left = 1;
        int right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (mins[mid] <= k){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println(mins[mid]);
        }
        while (left < n && answerKey.charAt(left - 1) == answerKey.charAt(left)){
            left++;
        }
        return left;
    }
}
