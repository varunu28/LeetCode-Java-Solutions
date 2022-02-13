class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(nums, 0, new ArrayList<>(), result);
    return new ArrayList<>(result);
  }

  private void helper(int[] nums, int currIdx, List<Integer> currSubset,
      List<List<Integer>> result) {
    result.add(new ArrayList<>(currSubset));
    if (currIdx >= nums.length) {
      return;
    }
    for (int i = currIdx; i < nums.length; i++) {
      currSubset.add(nums[i]);
      helper(nums, i + 1, currSubset, result);
      currSubset.remove(currSubset.size() - 1);
    }
  }
}
