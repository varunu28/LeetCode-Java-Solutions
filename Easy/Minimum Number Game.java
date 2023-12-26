class Solution {
    public int[] numberGame(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            result[i] = nums[i + 1];
            result[i + 1] = nums[i];
        }
        return result;
    }
}
