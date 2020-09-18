class Solution {
  public int[] numberOfLines(int[] widths, String S) {
    int numOfLines = 1;
    int currWidth = 0;
    for (char c : S.toCharArray()) {
      int width = widths[c - 'a'];
      currWidth += width;
      if (currWidth > 100) {
        numOfLines++;
        currWidth = width;
      }
    }
    return new int[]{numOfLines, currWidth};
  }
}
