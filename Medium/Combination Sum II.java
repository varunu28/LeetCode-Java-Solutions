class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);
    helper(candidates, 0, target, new ArrayList<>(), list);
    return list;
  }
  
  private void helper(int[] candidates, int idx, int target, List<Integer> temp, List<List<Integer>> list) {
    if (target == 0) {
      list.add(new ArrayList<>(temp));
      return;
    }
    if (target < 0) {
      return;
    }
    for (int i = idx; i < candidates.length; i++) {
      if (i > idx && candidates[i] == candidates[i - 1]) { 
        continue;
      }
      temp.add(candidates[i]);
      helper(candidates, i + 1, target - candidates[i], temp, list);
      temp.remove(temp.size() - 1);
    }
  }
}
