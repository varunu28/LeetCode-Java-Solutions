class Solution {
  public int maxArea(int[] height) {
    int maximumArea = 0;
    int leftIdx = 0;
    int rightIdx = height.length - 1;
    while (leftIdx < rightIdx) {
      int maxHeight = Math.min(height[leftIdx], height[rightIdx]);
      int currArea = maxHeight * (rightIdx - leftIdx);
      maximumArea = Math.max(currArea, maximumArea);
      if (maxHeight == height[leftIdx]) {
        leftIdx++;
      } else {
        rightIdx--;
      }
    }
    return maximumArea;
  }
}
