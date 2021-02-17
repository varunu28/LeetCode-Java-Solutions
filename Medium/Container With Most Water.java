class Solution {
  public int maxArea(int[] height) {
    int maxWater = 0;
    int start = 0;
    int end = height.length - 1;
    while (start < end) {
      int minHeight = Math.min(height[start], height[end]);
      maxWater = Math.max(maxWater, minHeight * (end - start));
      if (height[start] > height[end]) {
        end--;
      } else {
        start++;
      }
    }
    return maxWater;
  }
}
