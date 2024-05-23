class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Arrays.sort(nums);
        return countBeautifulSubsets(nums, k, freqMap, 0) - 1;
    }

    private int countBeautifulSubsets(int[] nums, int k, Map<Integer, Integer> freqMap, int idx) {
        if (idx == nums.length) {
            return 1;
        }
        int count = countBeautifulSubsets(nums, k, freqMap, idx + 1);
        if (freqMap.getOrDefault(nums[idx] - k, 0) == 0) {
            freqMap.put(nums[idx], freqMap.getOrDefault(nums[idx], 0) + 1);
            count += countBeautifulSubsets(nums, k, freqMap, idx + 1);
            freqMap.put(nums[idx], freqMap.getOrDefault(nums[idx], 0) - 1);
        }
        return count;
    }
}
