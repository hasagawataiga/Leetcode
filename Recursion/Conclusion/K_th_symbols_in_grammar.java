package Recursion.Conclusion;


// 1: 0
// 2: 01
// 3: 01 10
// 4: 0110 1001
// 5: 01101001 10010110
// 6: 0110100110010110 1001011001101001
// Using recursion find the parent of this k position
// There are 4 conditions:
//  1. parent is 1, k is even -> k = 0 
//  2. parent is 1, k is odd -> k = 1
//  3. parent is 0, k is even -> k = 1
//  4. parent is 0, k is odd -> k = 0
// Followed by the render rule: 0 -> 01, 1 -> 10
public class K_th_symbols_in_grammar {
    public int kthGrammar(int n, int k) {
        return kthGrammar(k);
    }
    private int kthGrammar(int k){
        if (k == 1){
            return 0;
        }
        if (k == 2){
            return 1;
        }
        int start = kthGrammar((k - 1)/2 + 1);
        if (start == 1){
            if (k%2 == 0){
                return 0;
            } else {
                return 1;
            }
        } else {
            if (k%2 == 0){
                return 1;
            } else {
                return 0;
            }
        }
    }
}
