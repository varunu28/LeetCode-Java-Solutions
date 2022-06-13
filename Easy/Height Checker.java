class Solution {
  public int heightChecker(int[] heights) {
    int[] frequencies = new int[101];
    for (int height : heights) {
      frequencies[height]++;
    }
    int currHeight = 1;
    int mismatchCount = 0;
    for (int height : heights) {
      while (frequencies[currHeight] == 0) {
        currHeight++;
      }
      if (currHeight != height) {
        mismatchCount++;
      }
      frequencies[currHeight]--;
    }
    return mismatchCount;
  }
}
