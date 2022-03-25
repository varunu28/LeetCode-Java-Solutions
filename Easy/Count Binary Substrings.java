class Solution {
  public int countBinarySubstrings(String s) {
    int totalCount = 0;
    int currCount = 0;
    int oppositeCount = 0;
    char currChar = s.charAt(0);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == currChar) {
        currCount++;
      } else {
        totalCount += Math.min(currCount, oppositeCount);
        oppositeCount = currCount;
        currCount = 1;
        currChar = s.charAt(i);
      }
    }
    return totalCount + Math.min(currCount, oppositeCount);
  }
}
