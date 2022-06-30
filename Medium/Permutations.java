class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    helper(nums, result, new ArrayList<>(), new boolean[nums.length]);
    return result;
  }
  
  private void helper(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean[] visited) {
    if (curr.size() == nums.length) {
      result.add(new ArrayList<>(curr));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (!visited[i]) {
          visited[i] = true;
          curr.add(nums[i]);
          helper(nums, result, curr, visited);
          visited[i] = false;
          curr.remove(curr.size() - 1);
        }
      }
    }
  }
}
