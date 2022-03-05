class Solution {
  public int mostFrequent(int[] nums, int key) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    int maxCountCandidate = -1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == key) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        if (map.get(nums[i]) > maxCount) {
          maxCount = map.get(nums[i]);
          maxCountCandidate = nums[i];
        }
      }
    }
    return maxCountCandidate;
  }
}
