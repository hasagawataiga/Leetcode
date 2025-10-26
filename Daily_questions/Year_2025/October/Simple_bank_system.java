package Daily_questions.Year_2025.October;

public class Simple_bank_system {
    class Bank {
        long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }
        
        public boolean transfer(int account1, int account2, long money) {
            if (!isValid(account1)) {
                return false;
            }
            if (!isValid(account2)) {
                return false;
            }
            if (!isEnoughMoney(account1, money)) {
                return false;
            }

            balance[getAccountIndex(account1)] -= money;
            balance[getAccountIndex(account2)] += money;

            return true;
        }
        
        public boolean deposit(int account, long money) {
            if (!isValid(account)) {
                return false;
            }

            balance[getAccountIndex(account)] += money;

            return true;
        }
        
        public boolean withdraw(int account, long money) {
            if (!isValid(account)) {
                return false;
            }
            if (!isEnoughMoney(account, money)) {
                return false;
            }

            balance[getAccountIndex(account)] -= money;
            
            return true;
        }

        private boolean isValid(int account) {
            return account - 1 < balance.length ? true : false;
        }

        private boolean isEnoughMoney(int account, long money) {
            return money <= balance[getAccountIndex(account)] ? true : false;
        }

        private int getAccountIndex(int account) {
            return account - 1;
        }
    }

    /**
     * Your Bank object will be instantiated and called as such:
     * Bank obj = new Bank(balance);
     * boolean param_1 = obj.transfer(account1,account2,money);
     * boolean param_2 = obj.deposit(account,money);
     * boolean param_3 = obj.withdraw(account,money);
     */
}
