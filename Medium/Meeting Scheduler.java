class Solution {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
    Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));
    int idxOne = 0;
    int idxTwo = 0;
    while (idxOne < slots1.length && idxTwo < slots2.length) {
      int maxStart = Math.max(slots1[idxOne][0], slots2[idxTwo][0]);
      int minEnd = Math.min(slots1[idxOne][1], slots2[idxTwo][1]);
      if (minEnd - maxStart >= duration) {
        return Arrays.asList(maxStart, maxStart + duration);
      }
      if (slots1[idxOne][1] > slots2[idxTwo][1]) {
        idxTwo++;
      } else {
        idxOne++;
      }
    }
    return new ArrayList<>();
  }
}
