class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    helper(list, curr, nums, 0, nums.length, new boolean[nums.length]);
    return list;
  }   
  
  private void helper(List<List<Integer>> list, List<Integer> curr, int[] nums, int idx, int n, boolean[] seen) {
    list.add(new ArrayList<>(curr));
    if (idx >= n) {
      return;
    }
    for (int i = idx; i < n; i++) {
      if (!seen[i]) {
        seen[i] = true;
        curr.add(nums[i]);
        helper(list, curr, nums, i + 1, n, seen);
        seen[i] = false;
        curr.remove(curr.size() - 1);
      }
    }
  }
}
