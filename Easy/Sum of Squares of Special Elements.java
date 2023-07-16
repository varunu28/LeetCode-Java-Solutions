class Solution {
    public int sumOfSquares(int[] nums) {
        return IntStream.range(0, nums.length)
                .filter(i -> nums.length % (i + 1) == 0)
                .map(i -> nums[i] * nums[i])
                .sum();
    }
}
