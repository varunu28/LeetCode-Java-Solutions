class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    helper(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }
    
  private void helper(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean[] visited) {
    if (curr.size() == nums.length) {
      result.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
        continue;
      }
      curr.add(nums[i]);
      visited[i] = true;
      helper(nums, result, curr, visited);
      curr.remove(curr.size() - 1);
      visited[i] = false;
    }
  }
}
