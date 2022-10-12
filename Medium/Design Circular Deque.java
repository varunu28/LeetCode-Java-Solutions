class MyCircularDeque {
  
  private Node head;
  private Node tail;
  private int k;
  private int currSize;

  public MyCircularDeque(int k) {
    this.k = k;
    this.currSize = 0;
    this.head = new Node(-1);
    this.tail = new Node(-1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    Node node = new Node(value);
    Node nextToHead = head.next;
    head.next = node;
    node.prev = head;
    node.next = nextToHead;
    nextToHead.prev = node;
    currSize++;
    return true;
  }

  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    Node node = new Node(value);
    Node prevToTail = tail.prev;
    tail.prev = node;
    node.next = tail;
    prevToTail.next = node;
    node.prev = prevToTail;
    currSize++;
    return true;
  }

  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    Node toDelete = head.next;
    deleteNode(toDelete);
    return true;
  }

  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    Node toDelete = tail.prev;
    deleteNode(toDelete);
    return true;
  }

  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return head.next.val;
  }

  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return tail.prev.val;
  }

  public boolean isEmpty() {
    return currSize == 0;
  }

  public boolean isFull() {
    return currSize == k;
  }
  
  private void deleteNode(Node node) {
    Node prevToNode = node.prev;
    Node nextToNode = node.next;
    prevToNode.next = nextToNode;
    nextToNode.prev = prevToNode;
    currSize--;
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
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
