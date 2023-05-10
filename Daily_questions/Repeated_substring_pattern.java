

public class Repeated_substring_pattern{
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        char lastCh = s.charAt(n - 1);
        int right = 0;
        while (right < n){
            int remainder = n % (right + 1);
            while (right < n && s.charAt(right) != lastCh && remainder == 0){
                remainder = n % (right + 1);
                right++;
            }
            if (right >= n - 1){
                return false;
            }
            String subString = s.substring(0, right + 1);
            StringBuilder sb = new StringBuilder();
            sb.append(subString);
            int times = n / (right + 1);
            for (int i = 1; i < times; i++){
                sb.append(subString);
            }
            if (sb.toString().equals(s)){
                return true;
            }
            right++;
        }
        return false;
    }
}