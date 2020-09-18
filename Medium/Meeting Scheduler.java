class Solution {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    int idx1 = 0;
    int idx2 = 0;
    Arrays.sort(slots1, new sortByStartAndEndTime());
    Arrays.sort(slots2, new sortByStartAndEndTime());
    while (idx1 < slots1.length && idx2 < slots2.length) {
      int maxStart = Math.max(slots1[idx1][0], slots2[idx2][0]);
      int minEnd = Math.min(slots1[idx1][1], slots2[idx2][1]);
      if (minEnd - maxStart >= duration) {
        return Arrays.asList(maxStart, maxStart + duration);
      }
      if (slots1[idx1][1] < slots2[idx2][1]) {
        idx1++;
      }
      else {
        idx2++;
      }
    }
    return new ArrayList<>();
  }

  class sortByStartAndEndTime implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
      int c = o1[0] - o2[0];
      if (c != 0) {
        return c;
      }
      return o1[1] - o2[1];
    }
  }
}
