class Solution {
  public int maxDistance(int[] colors) {
    int startIdx = 0;
    int endIdx = colors.length - 1;
    while (colors[0] == colors[endIdx]) {
      endIdx--;
    }
    while (colors[colors.length - 1] == colors[startIdx]) {
      startIdx++;
    }
    return Math.max(colors.length - 1 - startIdx, endIdx);
  }
}
