class Solution {
  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      maxCount = Math.max(maxCount, map.get(num));
    }
    int start = 0;
    int end = 0;
    map.clear();
    int minLength = Integer.MAX_VALUE;
    while (end < nums.length) {
      map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
      while (start <= end && map.get(nums[end]) == maxCount) {
        minLength = Math.min(minLength, end - start + 1);
        map.put(nums[start], map.get(nums[start]) - 1);
        start++;
      }
      end++;
    }
    return minLength;
  }
}
