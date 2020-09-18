class Solution {
  public int lengthLongestPath(String input) {
    int maxLen = 0;
    int currLevel = 1;
    boolean isFile = false;
    int currLen = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int idx = 0;
    int n = input.length();
    while (idx < n) {
      while (idx < n && input.charAt(idx) == '\t') {
        idx++;
        currLevel++;
      }
      while (idx < n && input.charAt(idx) != '\n') {
        if (input.charAt(idx) == '.') {
          isFile = true;
        }
        currLen++;
        idx++;
      }
      if (isFile) {
        maxLen = Math.max(maxLen, map.get(currLevel - 1) + currLen);
      }
      else {
        map.put(currLevel, map.get(currLevel - 1) + 1 + currLen);
      }
      currLen = 0;
      currLevel = 1;
      isFile = false;
      idx++;
    }
    return maxLen;
  }
}
