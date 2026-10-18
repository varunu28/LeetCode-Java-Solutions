class Solution {
    public int minDeletions(int[] nums) {
        int count = 0;
        int idx = 0;
        while (idx < nums.length) {
            int curr = nums[idx++];
            while (idx < nums.length && nums[idx] == curr) {
                idx++;
                count++;
            }
        }
        return count;
    }
}
