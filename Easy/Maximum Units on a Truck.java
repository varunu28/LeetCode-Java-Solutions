class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
      int c = o2[1] - o1[1];
      if (c != 0) {
        return c;
      }
      return o2[0] - o1[0];
    });
    Collections.addAll(pq, boxTypes);
    int maximumUnits = 0;
    while (truckSize > 0 && !pq.isEmpty()) {
      int[] boxType = pq.poll();
      int boxesAdded = Math.min(boxType[0], truckSize);
      maximumUnits += boxesAdded * boxType[1];
      truckSize -= boxesAdded;
    }
    return maximumUnits;
  }
}
