class BrowserHistory {

  private Stack<String> history;
  private Stack<String> future;

  public BrowserHistory(String homepage) {
    this.history = new Stack<>();
    this.history.push(homepage);
    this.future = new Stack<>();
  }

  public void visit(String url) {
    this.future.removeAllElements();
    this.history.push(url);
  }

  public String back(int steps) {
    while (steps-- > 0 && this.history.size() > 1) {
      this.future.push(this.history.pop());
    }
    return this.history.peek();
  }

  public String forward(int steps) {
    while (steps-- > 0 && !this.future.isEmpty()) {
      this.history.push(this.future.pop());
    }
    return this.history.peek();
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
