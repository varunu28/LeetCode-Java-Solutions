class MyLinkedList {
  
  private Node head;
  private Node tail;
  private int count;
  
  public MyLinkedList() {
    this.head = new Node(-1);
    this.tail = new Node(-1);
    head.next = tail;
    tail.prev = head;
    this.count = 0;
  }

  public int get(int index) {
    Node node = getNode(index);
    return node == null ? -1 : node.val;
  }

  public void addAtHead(int val) {
    Node node = new Node(val);
    Node nextNode = head.next;
    node.next = nextNode;
    node.prev = head;
    nextNode.prev = node;
    head.next = node;
    count++;
  }

  public void addAtTail(int val) {
    Node node = new Node(val);
    Node prevNode = tail.prev;
    node.next = tail;
    tail.prev = node;
    prevNode.next = node;
    node.prev = prevNode;
    count++;
  }

  public void addAtIndex(int index, int val) {
    if (index == count) {
      addAtTail(val);
    } else if (index < count) {
      Node nodeAtIndex = getNode(index);
      Node prevNode = nodeAtIndex.prev;
      Node node = new Node(val);
      node.prev = prevNode;
      prevNode.next = node;
      node.next = nodeAtIndex;
      nodeAtIndex.prev = node;
      count++;
    }
  }

  public void deleteAtIndex(int index) {
    Node node = getNode(index);
    if (node != null) {
      Node prevNode = node.prev;
      Node nextNode = node.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
      count--;
    }
  }
  
  private Node getNode(int index) {
    if (index >= count) {
      return null;
    }
    Node curr = head.next;
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }
    return curr;
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
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
