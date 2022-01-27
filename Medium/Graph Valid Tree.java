class Solution {
  public boolean validTree(int n, int[][] edges) {
    int[] nums = new int[n];
    Arrays.fill(nums, -1);
    for (int[] edge : edges) {
      int rootOne = find(nums, edge[0]);
      int rootTwo = find(nums, edge[1]);
      if (rootOne == rootTwo) {
        return false;
      }
      nums[rootOne] = rootTwo;
    }
    return edges.length == n - 1;
  }
  
  private int find(int[] nums, int n) {
    return nums[n] == -1 ? n : find(nums, nums[n]);
  }
}
