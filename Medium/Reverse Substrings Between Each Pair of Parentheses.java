class Solution {
  public String reverseParentheses(String s) {
    char[] letters = s.toCharArray();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else if (s.charAt(i) == ')') {
        reverse(letters, stack.pop(), i);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < letters.length; i++) {
      if (letters[i] == '(' || letters[i] == ')') {
        continue;
      }
      sb.append(letters[i]);
    }
    return sb.toString();
  }
  
  private void reverse(char[] letters, int start, int end) {
    while (start < end) {
      char temp = letters[start];
      letters[start++] = letters[end];
      letters[end--] = temp;
    }
  }
}
