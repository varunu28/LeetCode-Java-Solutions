class Solution {
  List<List<Integer>> list;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    list = new ArrayList<>();
    helper(candidates, 0, target, 0, new ArrayList<>());
    return list;
  }
  
  private void helper(int[] candidates, int idx, int target, int currSum, List<Integer> temp) {
    if (currSum == target) {
      list.add(new ArrayList<>(temp));
    }
    else if (idx == candidates.length || currSum > target) {
      return;
    }
    else {
      for (int i = idx; i < candidates.length; i++) {
        temp.add(candidates[i]);
        helper(candidates, i, target, currSum + candidates[i], temp);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
