class Solution {
  public boolean isCovered(int[][] ranges, int left, int right) {
    Arrays.sort(ranges, Comparator.comparingInt((int[] o) -> o[0]));
    for (int[] range : ranges) {
      if (left >= range[0] && left <= range[1]) {
        left = range[1] + 1;
      }
      if (left > right) {
        return true;
      }
    }
    return false;
  }
}
