class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = nums[0];   
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        final int arrayMin = min;
        final int arrayMax = max;
        return Arrays.stream(nums)
            .filter(num -> num != arrayMin && num != arrayMax)
            .findFirst()
            .orElse(-1);
    }
}
