package Biweekly_contest.Contest_100;

public class Distribute_money_to_maximum_children {
    public int distMoney(int money, int children) {
        int count = 0;
        if (money < children){
            return -1;
        } else if (money == children){
            return count;
        } else if (money == children*8){
            return children;
        // When Money > 8*children, it means (children - 1) have exactly 8 dollars and the last child has more than 8 dollars
        } else if (money > children*8){
            return children - 1;
        // For the case when (children - 1) have 8 dollars and the last child has 4 which broke the rule
        //  we have to take at least 1 dollar from one of "8 dollars" group to the last one,
        //  then count = children - 2 (1 is the last child has 4 dollars, 1 is the one has share 1 dollar to "4 dollar" guy)
        } else if (money == ((children - 1) * 8 + 4)){
            count = children - 2;
        } else {
            count = (money - children)/7;
        }
        // Use condition instead of directly return count because
        // There would had a case that count < 0 due to the previous algorithm,
        //  condition is used to ignore those unexpected cases
        return count > 0 ? count : 0;
    }
}
