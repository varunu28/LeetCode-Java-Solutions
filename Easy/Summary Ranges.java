class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        while (idx < nums.length) {
            int startIdx = idx;
            int endIdx = idx;
            idx++;
            while (idx < nums.length && nums[idx] - nums[idx - 1] == 1) {
                endIdx = idx++;
            }
            result.add(startIdx == endIdx ? String.valueOf(nums[startIdx]) : nums[startIdx] + "->" + nums[endIdx]);
        }
        return result;
    }
}
