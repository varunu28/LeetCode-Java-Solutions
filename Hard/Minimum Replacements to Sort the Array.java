class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long numOfOperations = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1];
                numOfOperations += numElements - 1;
                nums[i] = nums[i] / (int)numElements;
            }
        }
        return numOfOperations;
    }
}
