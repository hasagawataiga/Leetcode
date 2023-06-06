public class Lemonade_change {
    public boolean lemonadeChange(int[] bills) {
        // coins[0]: amount of 5
        // coins[1]: amount of 10
        int[] coins = new int[2];
        // int money = 0;
        for (int i = 0; i < bills.length; i++){
            switch (bills[i]){
                case 10:
                    coins[1]++;
                    break;
                case 5:
                    coins[0]++;
                    break;
            }
            int change = bills[i] - 5;
            while (change >= 10 && coins[1] > 0){
                change -= 10;
                coins[1]--;
            }
            while (change >= 5 && coins[0] > 0){
                change -= 5;
                coins[0]--;
            }
            if (change > 0){
                return false;
            }

        }
        return true;
    }
}
