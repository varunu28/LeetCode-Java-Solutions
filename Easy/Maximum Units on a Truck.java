class Solution {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
    int maxUnits = 0;
    for (int[] boxType : boxTypes) {
      if (truckSize == 0) {
        break;
      }
      int numberOfBoxesLoaded = Math.min(truckSize, boxType[0]);
      maxUnits += numberOfBoxesLoaded * boxType[1];
      truckSize -= numberOfBoxesLoaded;
    }
    return maxUnits;
  }
}
