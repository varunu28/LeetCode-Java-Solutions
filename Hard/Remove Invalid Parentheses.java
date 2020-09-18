class Solution {
  Set<String> validStrings;
  int minimumRemoved;
  public List<String> removeInvalidParentheses(String s) {
    validStrings = new HashSet<>();
    minimumRemoved = Integer.MAX_VALUE;
    backtrack(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList<>(validStrings);
  }
  
  private void backtrack(String s, int idx, int leftCount, int rightCount, StringBuilder sb, int removedCount) {
    if (idx == s.length()) {
      if (leftCount == rightCount) {
        if (removedCount <= minimumRemoved) {
          String possibleAns = sb.toString();
          if (removedCount < minimumRemoved) {
            validStrings.clear();
            minimumRemoved = removedCount;
          }
          validStrings.add(possibleAns);
        }
      }
    }
    else {
      char c = s.charAt(idx);
      if (c != '(' && c != ')') {
        sb.append(c);
        backtrack(s, idx + 1, leftCount, rightCount, sb, removedCount);
        sb.deleteCharAt(sb.length() - 1);
      }
      else {
        backtrack(s, idx + 1, leftCount, rightCount, sb, removedCount + 1);
        sb.append(c);
        if (c == '(') {
          backtrack(s, idx + 1, leftCount + 1, rightCount, sb, removedCount);
        }
        else if (rightCount < leftCount) {
          backtrack(s, idx + 1, leftCount, rightCount + 1, sb, removedCount);
        }
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
