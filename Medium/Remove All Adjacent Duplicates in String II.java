class Solution {
  public String removeDuplicates(String s, int k) {
    Stack<Pair> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek().ch == c) {
        stack.peek().val++;
      }
      else {
        stack.push(new Pair(c, 1));
      }
      if (stack.peek().val == k) {
        stack.pop();
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      Pair removed = stack.pop();
      int count = removed.val;
      while (count-- > 0) {
        sb.append(removed.ch);
      }
    }
    return sb.reverse().toString();
  }
}


class Pair {
  char ch;
  int val;
  
  public Pair(char ch, int val) {
    this.ch = ch;
    this.val = val;
  }
}
