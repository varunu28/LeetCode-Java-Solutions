class LRUCache {

  private final Map<Integer, Node> map;
  private final Node head;
  private final Node tail;
  private int capacity;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.head = new Node(-1, -1);
    this.tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!this.map.containsKey(key)) {
      return -1;
    }
    Node node = this.map.get(key);
    removeNode(node);
    addNode(node);
    return this.map.get(key).val;
  }

  public void put(int key, int value) {
    if (!map.containsKey(key)) {
      if (capacity == 0) {
        removeNode(tail.prev);
      }
    } else {
      removeNode(this.map.get(key));
    }
    addNode(new Node(key, value));
  }
  
  private void addNode(Node node) {
    Node nextToHead = head.next;
    head.next = node;
    node.next = nextToHead;
    nextToHead.prev = node;
    node.prev = head;
    this.map.put(node.key, node);
    this.capacity--;
  }
  
  private void removeNode(Node node) {
    Node nextNode = node.next;
    node.prev.next = nextNode;
    nextNode.prev = node.prev;
    this.map.remove(node.key);
    this.capacity++;
  }

  private static class Node {
    Node next;
    Node prev;
    int key;
    int val;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.next = null;
      this.prev = null;
    }
  }
}
