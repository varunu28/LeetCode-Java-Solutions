class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    Set<Integer> duplicates = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (duplicates.add(nums[i])) {
        for (int j = i + 1; j < nums.length; j++) {
          int target = -nums[i] - nums[j];
          if (map.containsKey(target) && map.get(target) == i) {
            List<Integer> temp = Arrays.asList(nums[i], nums[j], target);
            Collections.sort(temp);
            result.add(temp);
          }
          map.put(nums[j], i);
        }
      }
    }
    return new ArrayList<>(result);
  }
}
