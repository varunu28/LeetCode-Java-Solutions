class Solution {
  public boolean checkZeroOnes(String s) {
    int zeroBlock = 0;
    int oneBlock = 0;
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      char c = s.charAt(idx);
      int currCount = 0;
      while (idx < n && s.charAt(idx) == c) {
        currCount++;
        idx++;
      }
      if (c == '0') {
        zeroBlock = Math.max(zeroBlock, currCount);
      } else {
        oneBlock = Math.max(oneBlock, currCount);
      }
    }
    return oneBlock > zeroBlock;
  }
}
