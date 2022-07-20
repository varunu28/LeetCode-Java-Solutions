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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

  private Stack<NestedInteger> stack;
  
  public NestedIterator(List<NestedInteger> nestedList) {
    this.stack = new Stack<>();
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      this.stack.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    int value = this.stack.pop().getInteger();
    return value;
  }

  @Override
  public boolean hasNext() {
    while (!this.stack.isEmpty() && !this.stack.peek().isInteger()) {
      List<NestedInteger> ni = this.stack.pop().getList();
      for (int i = ni.size() - 1; i >= 0; i--) {
        this.stack.push(ni.get(i));
      }
    }
    return !this.stack.isEmpty();
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
