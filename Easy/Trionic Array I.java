class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        boolean firstIncrease = false;
        boolean firstDecrease = false;
        boolean secondIncrease = false;
        int idx = 0;
        while (idx < n - 1 && nums[idx] < nums[idx + 1]) {
            firstIncrease = true;
            idx++;
        }
        while (idx < n - 1 && nums[idx] > nums[idx + 1]) {
            firstDecrease = true;
            idx++;
        }
        while (idx < n - 1 && nums[idx] < nums[idx + 1]) {
            secondIncrease = true;
            idx++;
        }
        return idx == n - 1 && firstIncrease && firstDecrease && secondIncrease;
    }
}
