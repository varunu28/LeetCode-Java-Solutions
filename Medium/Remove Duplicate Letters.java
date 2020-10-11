class Solution {
  public String removeDuplicateLetters(String s) {
    int[] counter = new int[26];
    char[] charArray = s.toCharArray();
    for (char c : charArray) {
      counter[c - 'a']++;
    }
    boolean[] visited = new boolean[26];
    Stack<Character> stack = new Stack<>();
    for (Character c : charArray) {
      int idx = c - 'a';
      counter[idx]--;
      if (visited[idx]) {
        continue;
      }
      while (!stack.isEmpty() && c < stack.peek() && counter[stack.peek() - 'a'] > 0) {
        visited[stack.pop() - 'a'] = false;
      }
      stack.push(c);
      visited[idx] = true;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
}
