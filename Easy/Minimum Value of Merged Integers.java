class Solution {
    public int minMergedInteger(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i += 2) {
            int current = Integer.parseInt(nums[i] + "" + nums[i + 1]);
            result = Math.min(result, current);
        }
        return result;
    }
}
