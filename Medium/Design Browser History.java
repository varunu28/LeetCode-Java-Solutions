class BrowserHistory {
    
    private final Stack<String> history;
    private final Stack<String> future;

    public BrowserHistory(String homepage) {
        this.history = new Stack<>();
        this.future = new Stack<>();
        this.history.push(homepage);
    }
    
    public void visit(String url) {
        future.removeAllElements();
        history.push(url);
    }
    
    public String back(int steps) {
        while (steps-- > 0 && history.size() > 1) {
            future.push(history.pop());
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while (steps-- > 0 && !future.isEmpty()) {
            history.push(future.pop());
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
