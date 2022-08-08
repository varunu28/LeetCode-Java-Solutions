class Solution {
  public long countBadPairs(int[] nums) {
    long result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int prevCount = map.getOrDefault(i - nums[i], 0);
      result += i - prevCount;
      map.put(i - nums[i], prevCount + 1);
    }
    return result;
  }
}
