class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int idxOne = nums[0];
        int idxTwo = slow;
        while (idxOne != idxTwo) {
            idxOne = nums[idxOne];
            idxTwo = nums[idxTwo];
        }
        return idxOne;
    }
}
