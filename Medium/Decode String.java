class Solution {
  public String decodeString(String s) {
    Stack<Integer> countStack = new Stack<>();
    Stack<String> wordStack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while (idx < s.length()) {
      if (Character.isDigit(s.charAt(idx))) {
        int count = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
          count = count * 10 + Character.getNumericValue(s.charAt(idx++));
        }
        countStack.push(count);
      } else if (Character.isLetter(s.charAt(idx))) {
        sb.append(s.charAt(idx++));
      } else if (s.charAt(idx) == '[') {
        wordStack.push(sb.toString());
        sb.setLength(0);
        idx++;
      } else {
        StringBuilder temp = new StringBuilder(wordStack.pop());
        String currentString = sb.toString();
        sb.setLength(0);
        int count = countStack.pop();
        while (count-- > 0) {
          temp.append(currentString);
        }
        sb.append(temp);
        idx++;
      }
    }
    return sb.toString();
  }
}
