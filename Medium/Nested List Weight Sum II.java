/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Map.Entry;


class Solution {
  public int depthSumInverse(List<NestedInteger> nestedList) {
    Queue<NestedInteger> queue = new LinkedList<>();
    queue.addAll(nestedList);
    int totalSum = 0;
    int currSum = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      int levelSum = 0;
      while (size-- > 0) {
        NestedInteger nestedInteger = queue.remove();
        if (nestedInteger.isInteger()) {
          levelSum += nestedInteger.getInteger();
        } else {
          queue.addAll(nestedInteger.getList());
        }
      }
      currSum += levelSum;
      totalSum += currSum;
    }
    return totalSum;
  }
}
