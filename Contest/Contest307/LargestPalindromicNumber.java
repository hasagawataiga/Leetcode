import java.util.*;
public class LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        char array[] = num.toCharArray();
        Arrays.sort(array);
        int length = array.length;
        int[] temp = new int[10]; 
        for(int i = 0; i < length; i++){
            int index = array[i] - '0';
            if(i == 0){
                temp[index] = 1;
                continue;
            }
            if(array[i] == array[i-1]){
                temp[index]++;
            }else{
                temp[index] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean isLeading = true;
        for(int i = 9; i >= 0; i--){
            if(sb.length() != 0){
                isLeading = false;
            }
            if(isLeading && i == 0){
                continue;
            }
            if(temp[i]/2 > 0){
                for(int j = 0; j < temp[i]/2; j++){
                    sb.append(i);
                }
            }
        }
        String head = sb.toString();
        StringBuilder tail = new StringBuilder();
        tail = sb.reverse();
        for(int i = 9; i >= 0; i--){
            if(temp[i]%2 == 1){
                head = head + i;
                break;
            }
        }
        if(head == ""){
            return "0";
        }else{
            return head + tail.toString();   
        }
    }
}
