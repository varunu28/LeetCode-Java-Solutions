class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();
    helper(nums, 0, new ArrayList<>(), set);
    return new ArrayList<>(set);
  }
  
  private void helper(int[] nums, int idx, List<Integer> temp, Set<List<Integer>> set) {
    set.add(new ArrayList<>(temp));
    for (int i = idx; i < nums.length; i++) {
      temp.add(nums[i]);
      helper(nums, i + 1, temp, set);
      temp.remove(temp.size() - 1);
    }
  }
}
