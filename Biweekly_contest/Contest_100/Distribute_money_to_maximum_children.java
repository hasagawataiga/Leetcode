package Biweekly_contest.Contest_100;

public class Distribute_money_to_maximum_children {
    public int distMoney(int money, int children) {

        if (money < children){
            return -1;
        }
        int count = 0;
        if (money == children){
            return count;
        }
        if (money < 8){
            return 0;
        }
        if (money == children*8){
            return children;
        }
        while (money >= 8 && money > children && children > 0){
            money -= 8;
            children--;
            count++;
        }
        if (children == 0 && money > 0){
            return count - 1;
        }
        if (money == children){
            return count;
        }
        if (money < children){
            money += 8;
            count--;
            children++;
        }
        if (children == 1 && money == 4){
            count--;
        }
        return count < 0 ? 0 : count;
    }
}
