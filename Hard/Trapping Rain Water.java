class Solution {
    public int trap(int[] height) {
        int maxWater = 0;
        for (int i=1;i<height.length-1;i++) {
            int maxLeft = 0;
            int maxRight = 0;
            
            for (int j=i;j<height.length;j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            
            for (int j=i;j>=0;j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            
            maxWater += Math.min(maxLeft, maxRight) - height[i];
        }
        
        return maxWater;
    }
}
