class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long currSum = 0;
        long maxSum = 0;
        for (int i = 0; i < k - 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];
        }
        int startIdx = 0;
        for (int i = k - 1; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            currSum += nums[i];
            if (map.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
            map.put(nums[startIdx], map.get(nums[startIdx]) - 1);
            if (map.get(nums[startIdx]) == 0) {
                map.remove(nums[startIdx]);
            }
            currSum -= nums[startIdx];
            startIdx++;
        }
        return maxSum;
    }
}
