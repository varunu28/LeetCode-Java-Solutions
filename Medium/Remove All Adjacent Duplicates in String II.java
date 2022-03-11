class Solution {
  public String removeDuplicates(String s, int k) {
    Stack<CharPair> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek().c == c) {
        stack.peek().count++;
      } else {
        stack.push(new CharPair(c));
      }
      if (stack.peek().count == k) {
        stack.pop();
      }
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      CharPair pair = stack.pop();
      for (int i = 0; i < pair.count; i++) {
        sb.append(pair.c);
      }
    }
    return sb.reverse().toString();
  }
  
  private static class CharPair {
    char c;
    int count;
    
    public CharPair(char c) {
      this.c = c;
      this.count = 1;
    }
  }
}
