class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    helper(candidates, 0, ans, new ArrayList<>(), target);
    return ans;
  }
  
  private void helper(
    int[] candidates, int idx, List<List<Integer>> ans, List<Integer> list, int target
  ) {
    if (target == 0) {
      ans.add(new ArrayList<>(list));
      return;
    }
    if (target < 0 || idx == candidates.length) {
      return;
    }
    for (int i = idx; i < candidates.length; i++) {
      list.add(candidates[i]);
      helper(candidates, i, ans, list, target - candidates[i]);
      list.remove(list.size() - 1);
    }
  }
}
