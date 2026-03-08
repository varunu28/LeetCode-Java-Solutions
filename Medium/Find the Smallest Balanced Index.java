class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
        }
        int resultIdx = -1;
        long rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            leftSum -= nums[i];
            if (leftSum == rightProd) {
                return i;
            } 
            if (leftSum < rightProd) {
                break;
            }
            rightProd *= nums[i];
        }
        return -1;
    }
}
