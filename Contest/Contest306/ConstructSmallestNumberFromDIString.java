package Contest.Contest306;

public class ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        int length = pattern.length();
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < length; i++){
            temp.append('1' + i);
            if(i == length || pattern.charAt(i) == 'I'){
                result.append(temp.reverse());
                temp = new StringBuilder(0);
            }
        }
        return result.toString(); 
    }
}
