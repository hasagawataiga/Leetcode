package Daily_questions;

import java.util.Stack;

public class Design_browser_history {
    class BrowserHistory{
        Stack<String> backwardUrl = new Stack<>();
        Stack<String> forwardUrl = new Stack<>();
        String currentUrl = "";
        public BrowserHistory(String homepage) {
            backwardUrl.push(homepage);
            currentUrl = homepage;
        }
        
        public void visit(String url) {
            backwardUrl.push(currentUrl);
            currentUrl = url;
            forwardUrl = new Stack<>();
        }
        
        public String back(int steps) {
            while (steps > 0 && (backwardUrl.size() > 1)){
                forwardUrl.push(currentUrl);
                currentUrl = backwardUrl.pop();
                steps--;
            }
            return currentUrl;
        }
        
        public String forward(int steps) {
            while (!forwardUrl.empty() && steps > 0){
                backwardUrl.push(currentUrl);
                currentUrl = forwardUrl.pop();
                steps--;
            }
            return currentUrl;
        }
    }
}
