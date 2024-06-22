class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] % 2;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
