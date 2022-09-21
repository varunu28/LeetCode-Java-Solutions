class Solution {
  public int kEmptySlots(int[] bulbs, int k) {
    int n = bulbs.length;
    int[] position = new int[n + 1];
    for (int i = 0; i < n; i++) {
      position[bulbs[i]] = i;
    }
    int result = Integer.MAX_VALUE;
    int start = 1;
    int end = k + 2;
    for (int i = 1; end <= n; i++) {
      if (position[i] > position[start] && position[i] > position[end]) {
        continue;
      }
      if (i == end) {
        result = Math.min(result, Math.max(position[start], position[end]) + 1);
      }
      start = i;
      end = k + 1 + i;
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
