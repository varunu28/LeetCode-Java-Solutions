class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        while (end < n) {
            if (nums[end] % 2 == 0) {
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end] = temp;
            }
            end++;
        }
        return nums;
    }
}
