class Solution {
  public int maxArea(int[] height) {
    int start = 0;
    int end = height.length - 1;
    int maxArea = 0;
    while (start < end) {
      int minHeight = Math.min(height[start], height[end]);
      int dist = end - start;
      maxArea = Math.max(maxArea, minHeight * dist);
      if (height[start] > height[end]) {
        end--;
      }
      else {
        start++;
      }
    }
    return maxArea;
  }
}
