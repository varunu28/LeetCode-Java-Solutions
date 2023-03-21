class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarrayCount = 0L;
        int idx = 0;
        while (idx < nums.length) {
            long count = 0L;
            while (idx < nums.length && nums[idx] == 0) {
                idx++;
                count++;
            }
            subarrayCount += (count * (count + 1)) / 2;
            idx++;
        }
        return subarrayCount;
    }
}
