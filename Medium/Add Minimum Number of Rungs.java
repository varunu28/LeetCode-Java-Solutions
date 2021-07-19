class Solution {
  public int addRungs(int[] rungs, int dist) {
    int numOfRungs = 0;
    int currPos = 0;
    for (int rung : rungs) {
      numOfRungs += (rung - currPos - 1) / dist;
      currPos = rung;
    }
    return numOfRungs;
  }
}
