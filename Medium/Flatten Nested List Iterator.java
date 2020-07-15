/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
  List<NestedInteger> nestedList;
  Queue<Integer> queue;
  int idx;
  public NestedIterator(List<NestedInteger> nestedList) {
    this.nestedList = nestedList;
    queue = new LinkedList<>();
    idx = 0;
    addToQueue();
  }

  @Override
  public Integer next() {
    int val = queue.remove();
    if (queue.isEmpty()) {
      if (idx != nestedList.size()) {
        addToQueue();
      }
    }
    return val;
  }
  
  private void addToQueue() {
    while (idx < nestedList.size() && queue.isEmpty()) {
      addToQueueHelper(nestedList.get(idx++));
    }
  }
  
  private void addToQueueHelper(NestedInteger ns) {
    if (ns.isInteger()) {
      queue.add(ns.getInteger());
    }
    else {
      for (NestedInteger ni : ns.getList()) {
        addToQueueHelper(ni);
      }
    }
  }

  @Override
  public boolean hasNext() {
    return !(queue.isEmpty() && idx == nestedList.size());
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
