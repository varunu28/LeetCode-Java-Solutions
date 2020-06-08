class BrowserHistory {
  
  Node root;
  public BrowserHistory(String homepage) {
    root = new Node(homepage);
  }

  public void visit(String url) {
    Node node = new Node(url);
    root.next = null;
    root.next = node;
    node.prev = root;
    root = root.next;
  }

  public String back(int steps) {
    while (steps-- > 0 && root.prev != null) {
      root = root.prev;
    }
    return root.val;
  }

  public String forward(int steps) {
    while (steps-- > 0 && root.next != null) {
      root = root.next;
    }
    return root.val;
  }
}

class Node {
  String val;
  Node next;
  Node prev;
  
  public Node(String val) {
    this.val = val;
  }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
