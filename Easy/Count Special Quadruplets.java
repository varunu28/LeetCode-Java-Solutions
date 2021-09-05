class Solution {
  public int countQuadruplets(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    map.put(nums[nums.length - 1], 1);
    for (int i = nums.length - 2; i > 1; i--) {
      for (int j = i - 1; j > 0; j--) {
        for (int k = j - 1; k >= 0; k--) {
          if (map.containsKey(nums[i] + nums[j] + nums[k])) {
            count += map.get(nums[i] + nums[j] + nums[k]);
          }
        }
      }
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    return count;
  }   
}
