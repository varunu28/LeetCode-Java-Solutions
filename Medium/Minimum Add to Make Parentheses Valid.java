class Solution {
  public int minAddToMakeValid(String s) {
    int count = 0;
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          count++;
        } else {
          stack.pop();
        }
      }
    }
    return count + stack.size();
  }
}
