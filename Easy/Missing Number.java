class Solution {
  public int missingNumber(int[] nums) {
    return (nums.length * (nums.length + 1) / 2) - Arrays.stream(nums).boxed()
        .reduce(0, Integer::sum);
  }
}
