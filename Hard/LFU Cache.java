class LFUCache {

  private final Map<Integer, Node> keyToNodeMap;
  private final Map<Integer, Node[]> frequencyToNodeMap;
  private final Map<Integer, Integer> keyToFrequencyMap;
  private int capacity;
  private int currentCapacity;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.currentCapacity = 0;
    this.keyToNodeMap = new HashMap<>();
    this.frequencyToNodeMap = new TreeMap<>();
    this.keyToFrequencyMap = new HashMap<>();
  }

  public int get(int key) {
    if (!keyToNodeMap.containsKey(key)) {
      return -1;
    }
    Node node = keyToNodeMap.get(key);
    removeNode(node);
    int currentFrequency = keyToFrequencyMap.get(key);
    int newFrequency = currentFrequency + 1;
    keyToFrequencyMap.put(key, newFrequency);
    addNodeToFrequencyHead(node, newFrequency);
    return node.val;
  }

  public void put(int key, int value) {
    if (this.capacity == 0) {
      return;
    }
    removeNodeIfCapacityReached(key);
    Node node = getNode(key, value);
    int newFrequency = keyToFrequencyMap.getOrDefault(key, 0) + 1;
    keyToFrequencyMap.put(key, newFrequency);
    keyToNodeMap.put(key, node);
    if (newFrequency > 1) {
      removeNode(node);
    }
    addNodeToFrequencyHead(node, newFrequency);
  }

  private void removeNodeIfCapacityReached(int key) {
    if (!keyToNodeMap.containsKey(key) && this.currentCapacity == capacity) {
      for (Integer freq : frequencyToNodeMap.keySet()) {
        Node[] nodes = frequencyToNodeMap.get(freq);
        if (nodes[1].prev.val == -1) {
          continue;
        }
        Node toRemove = nodes[1].prev;
        removeNode(toRemove);
        keyToNodeMap.remove(toRemove.key);
        keyToFrequencyMap.remove(toRemove.key);
        this.currentCapacity--;
        break;
      }
    }
  }

  private Node getNode(int key, int value) {
    Node node;
    if (keyToNodeMap.containsKey(key)) {
      node = keyToNodeMap.get(key);
      removeNode(node);
      node.val = value;
    } else {
      this.currentCapacity++;
      node = new Node(value, key);
    }
    return node;
  }

  private void addNodeToFrequencyHead(Node node, int newFrequency) {
    if (!frequencyToNodeMap.containsKey(newFrequency)) {
      Node head = new Node(-1, Integer.MIN_VALUE);
      Node tail = new Node(-1, Integer.MAX_VALUE);
      head.next = tail;
      tail.prev = head;
      frequencyToNodeMap.put(newFrequency, new Node[]{head, tail});
    }
    Node headNode = frequencyToNodeMap.get(newFrequency)[0];
    Node nextToHead = headNode.next;
    nextToHead.prev = node;
    node.next = nextToHead;
    headNode.next = node;
    node.prev = headNode;
  }
  
  private void removeNode(Node node) {
    Node prevNode = node.prev;
    Node nextNode = node.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
  }

  private static class Node {
    int val;
    int key;
    Node next;
    Node prev;

    public Node(int val, int key) {
      this.val = val;
      this.key = key;
    }
  }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
