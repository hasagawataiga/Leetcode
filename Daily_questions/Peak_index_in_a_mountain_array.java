public class Peak_index_in_a_mountain_array {
    public int peakIndexInMountainArray(int[] arr) {
        return findPeak(arr, 0, arr.length - 1);
    }
    private int findPeak(int[] arr, int start, int end){
        int mid = start + (end - start) / 2;
        if (mid == 0 || mid == arr.length - 1){
            return mid;
        }
        // if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
        //     return mid;
        // }
        if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]){
            return findPeak(arr, start, mid);
        }
        if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]){
            return findPeak(arr, mid, end);
        }
        return mid;
    }
}
