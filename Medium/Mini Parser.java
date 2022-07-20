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
class Solution {
  public NestedInteger deserialize(String s) {
    if (s.isEmpty()) {
      return null;
    }
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.parseInt(s));
    }
    Stack<NestedInteger> stack = new Stack<>();
    NestedInteger curr = null;
    int leftIdx = 0;
    for (int rightIdx = 0; rightIdx < s.length(); rightIdx++) {
      if (s.charAt(rightIdx) == '[') {
        if (curr != null) {
          stack.push(curr);
        }
        curr = new NestedInteger();
        leftIdx = rightIdx + 1;
      } else if (s.charAt(rightIdx) == ']') {
        String number = s.substring(leftIdx, rightIdx);
        if (!number.isEmpty()) {
          curr.add(new NestedInteger(Integer.parseInt(number)));
        }
        if (!stack.isEmpty()) {
          NestedInteger popped = stack.pop();
          popped.add(curr);
          curr = popped;
        }
        leftIdx = rightIdx + 1;
      } else if (s.charAt(rightIdx) == ',') {
        if (s.charAt(rightIdx - 1) != ']') {
          String number = s.substring(leftIdx, rightIdx);
          curr.add(new NestedInteger(Integer.parseInt(number)));
        }
        leftIdx = rightIdx + 1;
      }
    }
    return curr;
  }
}
