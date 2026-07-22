class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int middle = nums[nums.length / 2];
        boolean found = false;
        for (int num : nums) {
            if (num == middle) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }
}
