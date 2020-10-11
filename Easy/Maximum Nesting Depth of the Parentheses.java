class Solution {
  public int maxDepth(String s) {
    int currCount = 0;
    int maxCount = 0;
    for (char c : s.toCharArray()) {
      currCount += c == '(' ? 1 : (c == ')' ? -1 : 0);
      maxCount = Math.max(maxCount, currCount);
    }
    return maxCount;
  }
}
