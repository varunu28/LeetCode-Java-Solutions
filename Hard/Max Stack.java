class MaxStack {
  
  private TreeMap<Integer, Stack<Node>> map;
  private Node head;
  private Node tail;
  
  public MaxStack() {
    this.map = new TreeMap<>();
    this.head = new Node(-1);
    this.tail = new Node(-1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public void push(int x) {
    Node node = createNode(x);
    map.computeIfAbsent(x, k -> new Stack<>()).push(node);
  }
  
  private Node createNode(int x) {
    Node node = new Node(x);
    Node prevToTail = tail.prev;
    node.next = tail;
    tail.prev = node;
    prevToTail.next = node;
    node.prev = prevToTail;
    return node;
  }

  public int pop() {
    Node toRemove = tail.prev;
    int val = toRemove.val;
    map.get(val).pop();
    if (map.get(val).isEmpty()) {
      map.remove(val);
    }
    removeNode(toRemove);
    return toRemove.val;
  }

  public int top() {
    return tail.prev.val;
  }

  public int peekMax() {
    return map.lastKey();
  }

  public int popMax() {
    int val = map.lastKey();
    Node node = map.get(val).pop();
    if (map.get(val).isEmpty()) {
      map.remove(val);
    }
    removeNode(node);
    return val;
  }
  
  private void removeNode(Node node) {
    Node prevNode = node.prev;
    Node nextNode = node.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }
  
  private static class Node {
    Node next;
    Node prev;
    int val;
    
    public Node(int val) {
      this.val = val;
    }
  }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
