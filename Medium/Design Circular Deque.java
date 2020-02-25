class MyCircularDeque {
  DequeNode head;
  DequeNode tail;
  int k;
  int currCapacity;

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque(int k) {
    currCapacity = 0;
    this.k = k;
    head = new DequeNode(-1);
    tail = new DequeNode(-1);
    head.front = tail;
    tail.back = head;
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }
    DequeNode node = new DequeNode(value);
    node.front = head.front;
    head.front.back = node;
    node.back = head;
    head.front = node;
    currCapacity++;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }
    DequeNode node = new DequeNode(value);
    node.front = tail;
    node.back = tail.back;
    tail.back.front = node;
    tail.back = node;
    currCapacity++;
    return true;
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }
    DequeNode next = head.front.front;
    head.front = next;
    next.back = head;
    currCapacity--;
    return true;
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }
    DequeNode prev = tail.back.back;
    tail.back = prev;
    prev.front = tail;
    currCapacity--;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    if (isEmpty()) {
      return -1;
    }
    return head.front.val;
  }

  /** Get the last item from the deque. */
  public int getRear() {
    if (isEmpty()) {
      return -1;
    }
    return tail.back.val;
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return currCapacity == 0;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return currCapacity == k;
  }
}

class DequeNode {
  int val;
  DequeNode front;
  DequeNode back;
  
  public DequeNode(int val) {
    this.val = val;
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
