class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    helper(candidates, 0, target, new ArrayList<>(), result);
    return result;
  }

  private void helper(int[] candidates, int idx, int target, List<Integer> currCombination,
      List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(currCombination));
    } 
    if (target > 0 && idx < candidates.length) {
      for (int i = idx; i < candidates.length; i++) {
        currCombination.add(candidates[i]);
        helper(candidates, i, target - candidates[i], currCombination, result);
        currCombination.remove(currCombination.size() - 1);
      }
    }
  }
}
