class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < n) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (start < end && map.get(nums[end]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            end++;
            result = Math.max(result, end - start);
        }
        return result;
    }
}
