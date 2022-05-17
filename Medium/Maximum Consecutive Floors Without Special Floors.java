class Solution {
  public int maxConsecutive(int bottom, int top, int[] special) {
    Arrays.sort(special);
    int maxConsecutiveFloors = Math.max(special[0] - bottom, top - special[special.length - 1]);
    for (int specialFloor : special) {
      int emptyFloors = specialFloor - bottom;
      bottom = specialFloor + 1;
      maxConsecutiveFloors = Math.max(maxConsecutiveFloors, emptyFloors);
    }
    return maxConsecutiveFloors;
  }
}
