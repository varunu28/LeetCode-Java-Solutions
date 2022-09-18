class Solution {
  public int trap(int[] height) {
    int leftIdx = 0;
    int rightIdx = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int result = 0;
    while (leftIdx < rightIdx) {
      if (height[leftIdx] < height[rightIdx]) {
        if (height[leftIdx] >= leftMax) {
          leftMax = height[leftIdx];
        } else {
          result += leftMax - height[leftIdx];
        }
        leftIdx++;
      } else {
        if (height[rightIdx] >= rightMax) {
          rightMax = height[rightIdx];
        } else {
          result += rightMax - height[rightIdx];
        }
        rightIdx--;
      }
    }
    return result;
  }
}
