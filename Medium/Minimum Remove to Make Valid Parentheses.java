class Solution {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> validIndexes = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.add(i);
      } else if (s.charAt(i) == ')') {
        if (!stack.isEmpty()) {
          validIndexes.add(stack.pop());
          validIndexes.add(i);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')') {
        if (validIndexes.contains(i)) {
          sb.append(s.charAt(i));
        }
      } else {
        sb.append(s.charAt(i));
      }
    }
    return sb.toString();
  }
}
