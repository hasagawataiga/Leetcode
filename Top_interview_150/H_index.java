package Top_interview_150;

public class H_index {
    public int hIndex(int[] citations) {
        int left = 1;
        int right;
        if (citations.length >= 1000){
            right = 1000;
        } else {
            right = citations.length;
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (binarySearch(citations, mid) > mid){
                left = mid + 1;
            } else if (binarySearch(citations, mid) == mid){
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return left + (right - left) / 2;
    }
    private int binarySearch(int[] citations, int num){
        int count = 0;
        for (int citation : citations){
            if (citation >= num){
                count++;
            }
        }
        return count;
    }
}
