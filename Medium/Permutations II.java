class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums.length == 0) {
      return ans;
    }
    List<Integer> curr = new ArrayList<>();
    Arrays.sort(nums);
    helper(nums, ans, curr, new boolean[nums.length]);
    return ans;
  }
  
  private void helper(int[] nums, List<List<Integer>> ans, List<Integer> curr, boolean[] used) {
    if (curr.size() == nums.length) {
      ans.add(new ArrayList<>(curr));
    }
    else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i]) {
          continue;
        }
        if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
          continue;
        }
        used[i] = true;
        curr.add(nums[i]);
        helper(nums, ans, curr, used);
        curr.remove(curr.size() - 1);
        used[i] = false;
      }
    }
  }
}

