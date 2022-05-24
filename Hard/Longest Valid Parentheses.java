class Solution {
  public int longestValidParentheses(String s) {
    int maxLength = 0;
    int leftIdx = 0;
    int rightIdx = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        leftIdx++;
      } else {
        rightIdx++;
      }
      if (leftIdx == rightIdx) {
        maxLength = Math.max(maxLength, 2 * rightIdx);
      } else if (rightIdx > leftIdx) {
        leftIdx = rightIdx = 0;
      }
    }
    leftIdx = 0;
    rightIdx = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        leftIdx++;
      } else {
        rightIdx++;
      }
      if (leftIdx == rightIdx) {
        maxLength = Math.max(maxLength, 2 * rightIdx);
      } else if (leftIdx > rightIdx) {
        leftIdx = rightIdx = 0;
      }
    }
    return maxLength;
  }
}
