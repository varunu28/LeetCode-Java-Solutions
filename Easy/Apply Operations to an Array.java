class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < nums.length) {
            if (nums[endIdx] != 0) {
                nums[startIdx++] = nums[endIdx];
            }
            endIdx++;
        }
        while (startIdx < nums.length) {
            nums[startIdx++] = 0;
        }
        return nums;
    }
}
