class Solution {
  public int maximumUniqueSubarray(int[] nums) {
    int maximumSum = 0;
    int currSum = 0;
    int start = 0;
    int end = 0;
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    while (end < n) {
      int currNum = nums[end++];
      map.put(currNum, map.getOrDefault(currNum, 0) + 1);
      currSum += currNum;
      while (start < end && map.get(currNum) > 1) {
        map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
        currSum -= nums[start++];
      }
      maximumSum = Math.max(maximumSum, currSum);
    }
    return maximumSum;
  }
}
