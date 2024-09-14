class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
                result = count = 0;
            }
            if (max == num) {
                count++;
            } else {
                count = 0;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
