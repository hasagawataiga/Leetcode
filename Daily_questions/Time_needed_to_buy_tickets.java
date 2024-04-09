public class Time_needed_to_buy_tickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int length = tickets.length;
        int estimatedTimeTotal = (tickets[k] - 1) * length + k + 1;
        for (int i = 0; i < k; i++) {
            if (tickets[i] < tickets[k]) {
                estimatedTimeTotal -= tickets[k] - tickets[i];
            }
        }
        for(int i = k + 1; i < length; i++) {
            if (tickets[i] < tickets[k]) {
                estimatedTimeTotal -= tickets[k] - tickets[i] - 1;
            }
        }
        return estimatedTimeTotal;
    }
}
