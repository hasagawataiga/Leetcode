package Contest.Contest311;

class Solution {
    public int smallestEvenMultiple(int n) {
        if(n == 1){
            return 2;
        }
        else if(n%2 == 0){
            return n;
        }else{
            return n*2;
        }
    }
}