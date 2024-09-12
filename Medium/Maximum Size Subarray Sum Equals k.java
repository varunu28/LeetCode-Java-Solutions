class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                max = i + 1;
            } else if (map.containsKey(prefixSum - k)) {
                max = Math.max(max, i - map.get(prefixSum - k));
            }
            map.putIfAbsent(prefixSum, i);
        }
        return max;
    }
}
