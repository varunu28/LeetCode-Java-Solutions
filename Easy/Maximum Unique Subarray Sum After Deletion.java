class Solution {
    public int maxSum(int[] nums) {
        int max = nums[0];
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            max = Math.max(num, max);
            if (num > 0 && set.add(num)) {
                sum += num;
            }
        }
        if (max < 0) {
            return max;
        }
        return sum;
    }
}
