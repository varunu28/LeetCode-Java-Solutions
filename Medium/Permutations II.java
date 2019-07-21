class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Set<List<Integer>> ans = new HashSet <>();
    Map <Integer, Integer> map = new HashMap <>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    permuteHelper(nums, nums.length, ans, map, new ArrayList<>());
    return new ArrayList <>(ans);
  }

  private void permuteHelper(int[] nums, int length, Set<List<Integer>> ans, Map<Integer, Integer> used, ArrayList<Integer> curr) {
    if (curr.size() == length) {
      ans.add(new ArrayList <>(curr));
      return;
    }

    for (int i = 0; i < length; i++) {
      if (used.get(nums[i]) != 0) {
        used.put(nums[i], used.get(nums[i]) - 1);
        curr.add(nums[i]);
        permuteHelper(nums, length, ans, used, curr);
        used.put(nums[i], used.get(nums[i]) + 1);
        curr.remove(curr.size() - 1);
      }
    }
  }
}
