class FrontMiddleBackQueue {

  Deque<Integer> frontQueue;
  Deque<Integer> backQueue;

  public FrontMiddleBackQueue() {
    frontQueue = new ArrayDeque<>();
    backQueue = new ArrayDeque<>();
  }

  public void pushFront(int val) {
    frontQueue.addFirst(val);
  }

  public void pushMiddle(int val) {
    while (frontQueue.size() + 1 < backQueue.size()) {
      frontQueue.addLast(backQueue.removeFirst());
    }
    while (frontQueue.size() > backQueue.size()) {
      backQueue.addFirst(frontQueue.removeLast());
    }
    frontQueue.addLast(val);
  }

  public void pushBack(int val) {
    backQueue.addLast(val);
  }

  public int popFront() {
    return frontQueue.isEmpty()
        ? (backQueue.isEmpty() ? -1 : backQueue.removeFirst())
        : frontQueue.removeFirst();
  }

  public int popMiddle() {
    if (frontQueue.isEmpty() && backQueue.isEmpty()) {
      return -1;
    }
    while (frontQueue.size() < backQueue.size()) {
      frontQueue.addLast(backQueue.removeFirst());
    }
    while (frontQueue.size() > backQueue.size() + 1) {
      backQueue.addFirst(frontQueue.removeLast());
    }
    return !frontQueue.isEmpty() ? frontQueue.removeLast() : backQueue.removeFirst();
  }

  public int popBack() {
    return backQueue.isEmpty()
        ? (frontQueue.isEmpty() ? -1 : frontQueue.removeLast())
        : backQueue.removeLast();
  }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
