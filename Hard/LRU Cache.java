class LRUCache {
  Node head;
  Node tail;
  Map<Integer, Node> map;
  int capacity;
  public LRUCache(int capacity) {
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
    map = new HashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    int val = map.get(key).val;
    moveToFront(map.get(key));
    return val;
  }

  public void put(int key, int value) {
    if (!map.containsKey(key)) {
      if (map.size() == capacity) {
        evictKey(tail.prev);
      }
      Node node = new Node(key, value);
      map.put(key, node);
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
      node.prev = head;
    }
    else {
      map.get(key).val = value;
      moveToFront(map.get(key));
    }
  }
  
  private void moveToFront(Node node) {
    Node prev = node.prev;
    node.next.prev = prev;
    prev.next = node.next;
    node.next = head.next;
    head.next.prev = node;
    node.prev = head;
    head.next = node;
  }
  
  private void evictKey(Node node) {
    Node prev = node.prev;
    node.next.prev = prev;
    prev.next = node.next;
    map.remove(node.key);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node {
  int key;
  int val;
  Node next;
  Node prev;
  
  public Node(int key, int val) {
    this.key = key;
    this.val = val;
    next = null;
    prev = null;
  }
}
