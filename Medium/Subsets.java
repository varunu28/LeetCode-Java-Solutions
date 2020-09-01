class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    helper(nums, list, new ArrayList<>(), 0);
    return list;
  }
  
  private void helper(int[] nums, List<List<Integer>> list, List<Integer> curr, int idx) {
    list.add(new ArrayList<>(curr));
    if (idx >= nums.length) {
      return;
    }
    for (int i = idx; i < nums.length; i++) {
      curr.add(nums[i]);
      helper(nums, list, curr, i + 1);
      curr.remove(curr.size() - 1);
    }
  }
}
