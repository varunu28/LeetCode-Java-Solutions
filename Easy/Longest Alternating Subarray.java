class Solution {
    public int alternatingSubarray(int[] nums) {
        int start = 0;
        int maxLength = -1;
        int expectedDiff = 1;
        for (int i = 1; i < nums.length;) {
            if (nums[i] - nums[i - 1] != expectedDiff) {
                if (nums[i] - nums[i - 1] != 1) {
                    i++;
                } 
                start = i - 1;
                expectedDiff = 1;
                continue;
            }
            expectedDiff *= -1;
            maxLength = Math.max(maxLength, i - start + 1);
            i++;
        }
        return maxLength;
    }
}
