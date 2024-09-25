import java.util.Stack;

public class Online_stock_span {
    class StockSpanner {
        class Stock {
            int val;
            int span;
            Stock(int val, int span) {
                this.val = val;
                this.span = span;
            }
            public int getVal() {return this.val;}
            public int getSpan() {return this.span;}
        }
        Stack<Stock> stocks;
        public StockSpanner() {
            stocks = new Stack<>();       
        }
        
        public int next(int price) {
            int count = 1;
            while (!stocks.isEmpty() && stocks.peek().getVal() <= price) {
                count += stocks.pop().getSpan();
            }
            stocks.push(new Stock(price, count));
            return count;
        }
    }
}
