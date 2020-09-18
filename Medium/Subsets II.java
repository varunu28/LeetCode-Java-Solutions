class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    int n = nums.length;
    Arrays.sort(nums);
    helper(nums, 0, n, ans, curr);
    return new ArrayList<>(ans);
  }
  
  private void helper(int[] nums, int idx, int n, List<List<Integer>> ans, List<Integer> curr) {
    ans.add(new ArrayList<>(curr));
    if (idx >= n) {
      return;
    }
    for (int i = idx; i < n; i++) {
      if (i > idx && nums[i] == nums[i - 1]) {
        continue;
      }
      curr.add(nums[i]);
      helper(nums, i + 1, n, ans, curr);
      curr.remove(curr.size() - 1);
    } 
  }
}
