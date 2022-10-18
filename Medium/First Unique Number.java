class FirstUnique {
  
  private Node head;
  private Node tail;
  private Map<Integer, Node> map;
  
  public FirstUnique(int[] nums) {
    this.head = new Node(-1);
    this.tail = new Node(-1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        deleteNode(map.get(num));
      } else {
        Node node = new Node(num);
        map.put(num, node);
        addToTail(node);
      }
    }
  }

  public int showFirstUnique() {
    return this.head.next.val;
  }

  public void add(int value) {
    if (map.containsKey(value)) {
      deleteNode(map.get(value));
      return;
    }
    Node node = new Node(value);
    map.put(value, node);
    addToTail(node);
  }
  
  private void addToTail(Node node) {
    Node prevToTail = this.tail.prev;
    prevToTail.next = node;
    node.next = this.tail;
    node.prev = prevToTail;
    this.tail.prev = node;
  }
  
  private void deleteNode(Node node) {
    if (node == null) {
      return;
    }
    map.put(node.val, null);
    Node prevToNode = node.prev;
    Node nextToNode = node.next;
    prevToNode.next = nextToNode;
    nextToNode.prev = prevToNode;
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
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
