class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        return IntStream.range(0, nums.size())
            .filter(idx -> Integer.bitCount(idx) == k)
            .map(idx -> nums.get(idx))
            .sum();
    }
}
