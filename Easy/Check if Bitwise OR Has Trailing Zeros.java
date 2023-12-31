class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        return Arrays.stream(nums)
                .filter(num -> Integer.numberOfTrailingZeros(num) > 0)
                .count() >= 2;
    }
}
