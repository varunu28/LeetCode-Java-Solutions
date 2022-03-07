class Solution {
  public long minimalKSum(int[] nums, int k) {
    Arrays.sort(nums);
    long sum = 0;
    long low = 1;
    for (int num : nums) {
      if (num > low) {
        long high = Math.min(num - 1, low + k - 1);
        int count = (int) (high - low + 1);
        sum += (low + high) * count / 2;
        k -= count;
        if (k == 0) {
          return sum;
        }
      }
      low = num + 1;
    }
    return sum + (2 * low + k - 1) * k / 2;
  }
}
