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
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
  public NestedInteger deserialize(String s) {
    if (s == null || s.length() == 0) {
      return null;
    }
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.valueOf(s));
    }
    Stack<NestedInteger> stack = new Stack<>();
    NestedInteger curr = null;
    int start = 0;
    int n = s.length();
    for (int end = 0; end < n; end++) {
      char c = s.charAt(end);
      if (c == '[') {
        if (curr != null) {
          stack.push(curr);
        }
        curr = new NestedInteger();
        start = end + 1;
      }
      else if (c == ']') {
        String num = s.substring(start, end);
        if (!num.isEmpty()) {
          curr.add(new NestedInteger(Integer.valueOf(num)));
        }
        if (!stack.isEmpty()) {
          NestedInteger popped = stack.pop();
          popped.add(curr);
          curr = popped;
        }
        start = end + 1;
      }
      else if (c == ',') {
        if (s.charAt(end - 1) != ']') {
          String num = s.substring(start, end);
          curr.add(new NestedInteger(Integer.valueOf(num)));
        }
        start = end + 1;
      }
    }
    return curr;
  }
}
