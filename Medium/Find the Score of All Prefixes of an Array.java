class Solution {
    public long[] findPrefixScore(int[] nums) {
        int[] conver = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            conver[i] = nums[i] + max;
        }
        long[] result = new long[nums.length];
        long score = 0;
        for (int i = 0; i < nums.length; i++) {
            score += conver[i];
            result[i] = score;
        }
        return result;
    }
}
