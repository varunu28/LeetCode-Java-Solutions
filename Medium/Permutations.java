class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList <>();
    Set<Integer> used = new HashSet <>();
    permuteHelper(nums, nums.length, ans, used, new ArrayList<>());
    return ans;
  }

  private void permuteHelper(int[] nums, int length, List<List<Integer>> ans,
                                    Set<Integer> used, ArrayList<Integer> curr) {
    if (curr.size() == length) {
      ans.add(new ArrayList <>(curr));
      return;
    }

    for (int i = 0; i < length; i++) {
      if (!used.contains(nums[i])) {
        used.add(nums[i]);
        curr.add(nums[i]);
        permuteHelper(nums, length, ans, used, curr);
        used.remove(nums[i]);
        curr.remove(curr.size() - 1);
      }
    }
  }
}
