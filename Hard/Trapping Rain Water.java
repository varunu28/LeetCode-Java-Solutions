class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int leftIdx = 0;
        int rightIdx = n - 1;
        int leftMax = height[leftIdx];
        int rightMax = height[rightIdx];
        while (leftIdx < rightIdx) {
            if (leftMax <= rightMax) {
                leftIdx++;
                leftMax = Math.max(leftMax, height[leftIdx]);
                result += leftMax - height[leftIdx];
            } else {
                rightIdx--;
                rightMax = Math.max(rightMax, height[rightIdx]);
                result += rightMax - height[rightIdx];
            }
        }
        return result;
    }
}
