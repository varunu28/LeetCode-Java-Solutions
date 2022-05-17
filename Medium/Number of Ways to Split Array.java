class Solution {
	public int waysToSplitArray(int[] nums) {
		long arraySum = 0;
		for (int i = 0; i < nums.length; i++) {
			arraySum += nums[i];
		}
		int ways = 0;
    long prefixSum = 0;
		for (int i = 0; i < nums.length - 1; i++) {
      prefixSum += nums[i];
			if (prefixSum >= arraySum - prefixSum) {
				ways++;
			}			
		}
		return ways;
  }
}
