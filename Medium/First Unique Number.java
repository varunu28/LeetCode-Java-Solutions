class FirstUnique {
  Node head;
  Node tail;
  Map<Integer, Node> map;
  int MX_VAL = Integer.MAX_VALUE;
  int MN_VAL = Integer.MIN_VALUE;
  public FirstUnique(int[] nums) {
    map = new HashMap<>();
    head = new Node(MN_VAL);
    tail = new Node(MX_VAL);
    head.next = tail;
    tail.prev = head;
    for (int num : nums) {
      add(num);
    }
  }

  public int showFirstUnique() {
    return head.next.val == MX_VAL ? -1 : head.next.val;
  }

  public void add(int value) {
    if (map.containsKey(value)) {
      if (map.get(value) != null) {
        remove(map.get(value));
        map.put(value, null);
      }
    }
    else {
      Node newNode = new Node(value);
      map.put(value, newNode);
      newNode.prev = tail.prev;
      tail.prev.next = newNode;
      newNode.next = tail;
      tail.prev = newNode;
    }
  }
  
  private void remove(Node node) {
    Node prev = node.prev;
    Node next = node.next;
    prev.next = next;
    next.prev = prev;
  }
}

class Node {
  int val;
  Node next;
  Node prev;
  
  public Node(int val) {
    this.val = val;
  }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
