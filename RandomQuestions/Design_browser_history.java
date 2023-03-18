package RandomQuestions;

public class Design_browser_history {
    class BrowserHistory {
        class Node {
            String val;
            Node prev;
            Node next;
            Node(){}
            Node(String val){
                this.val = val;
            }
        }
        Node curr;
        
        public BrowserHistory(String homepage) {
            curr = new Node(homepage);
        }
        
        public void visit(String url) {
            Node node = new Node(url);
            curr.next = node;
            node.prev = curr;
            curr = node;
        }
        
        public String back(int steps) {
            while(steps > 0 && curr.prev != null){
                curr = curr.prev;
                steps--;
            }
            return curr.val;
        }
        
        public String forward(int steps) {
            while(steps > 0 && curr.next != null){
                curr = curr.next;
                steps--;
            }
            return curr.val;
        }
    }
}
