class Skiplist {
  
  private Node head;
  private Random random;

  public Skiplist() {
    this.head = new Node(-1);
    this.random = new Random();
  }

  public boolean search(int target) {
    Node curr = head;
    while (curr != null) {
      while (curr.next != null && curr.next.val < target) {
        curr = curr.next;
      }
      if (curr.next != null && curr.next.val == target) {
        return true;
      }
      curr = curr.down;
    }
    return false;
  }

  public void add(int num) {
    Stack<Node> stack = new Stack<>();
    Node curr = head;
    while (curr != null) {
      while (curr.next != null && curr.next.val < num) {
        curr = curr.next;
      }
      stack.push(curr);
      curr = curr.down;
    }
    boolean newLevel = true;
    Node downNode = null;
    while (newLevel && !stack.isEmpty()) {
      curr = stack.pop();
      Node newNode = new Node(num);
      newNode.next = curr.next;
      newNode.down = downNode;
      curr.next = newNode;
      downNode = curr.next;
      newLevel = random.nextDouble() < 0.5;
    }
    if (newLevel) {
      Node prevHead = head;
      head = new Node(-1);
      head.down = prevHead;
    }
  }

  public boolean erase(int num) {
    Node curr = head;
    boolean found = false;
    while (curr != null) {
      while (curr.next != null && curr.next.val < num) {
        curr = curr.next;
      }
      if (curr.next != null && curr.next.val == num) {
        found = true;
        curr.next = curr.next.next;
      }
      curr = curr.down;
    }
    return found;
  }
  
  private static class Node {
    int val;
    Node next;
    Node down;
    
    public Node(int val) {
      this.val = val;
    }
  }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
