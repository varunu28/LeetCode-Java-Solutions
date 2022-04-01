class MaxStack {

  private Node stackHead;
  private Node stackTail;
  private PriorityQueue<Integer> maxValues;
  private Map<Integer, Stack<Node>> valToNodeMapping;

  public MaxStack() {
    this.stackHead = new Node(Integer.MIN_VALUE);
    this.stackTail = new Node(Integer.MAX_VALUE);
    this.stackTail.prev = this.stackHead;
    this.stackHead.next = this.stackTail;
    this.maxValues = new PriorityQueue<>((o1, o2) -> o2 - o1);
    this.valToNodeMapping = new HashMap<>();
  }

  public void push(int x) {
    Node node = new Node(x);
    if (!this.valToNodeMapping.containsKey(x)) {
      this.maxValues.add(x);
    }
    addNodeToStack(node);
    this.valToNodeMapping.computeIfAbsent(x, k -> new Stack<>()).push(node);
  }

  public int pop() {
    Node toRemove = this.stackHead.next;
    this.valToNodeMapping.get(toRemove.val).pop();
    removeNodeFromStack(toRemove);
    return toRemove.val;
  }

  public int top() {
    return this.stackHead.next.val;
  }

  public int peekMax() {
    moveToMaxValue();
    int maxVal = this.maxValues.peek();
    return this.valToNodeMapping.get(maxVal).peek().val;
  }

  public int popMax() {
    moveToMaxValue();
    int maxVal = this.maxValues.peek();
    Node toRemove = this.valToNodeMapping.get(maxVal).pop();
    removeNodeFromStack(toRemove);
    return toRemove.val;
  }
  
  private void moveToMaxValue() {
    while (this.valToNodeMapping.get(this.maxValues.peek()).isEmpty()) {
      this.valToNodeMapping.remove(this.maxValues.poll());
    }
  }

  private void addNodeToStack(Node node) {
    Node nextToHead = this.stackHead.next;
    nextToHead.prev = node;
    node.next = nextToHead;
    this.stackHead.next = node;
    node.prev = this.stackHead;
  }

  private void removeNodeFromStack(Node node) {
    Node nextNode = node.next;
    Node prevNode = node.prev;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }

  private static class Node {
    int val;
    Node next;
    Node prev;

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
