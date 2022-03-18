class Solution {
  public String removeDuplicateLetters(String s) {
    int[] counter = new int[26];
    for (char c : s.toCharArray()) {
      counter[c - 'a']++;
    }
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[26];
    for (char c : s.toCharArray()) {
      int idx = c - 'a';
      counter[idx]--;
      if (visited[idx]) {
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > idx && counter[stack.peek()] > 0) {
        visited[stack.pop()] = false;
      }
      stack.add(idx);
      visited[idx] = true;
    }
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append((char) (stack.pop() + 'a'));
    }
    return sb.reverse().toString();
  }
}
