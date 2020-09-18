class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();
    helper(ans, curr, new boolean[n], k, 0);
    return ans;
  }
  
  private void helper(List<List<Integer>> ans, List<Integer> curr, boolean[] visited, int k, int idx) {
    if (curr.size() == k) {
      ans.add(new ArrayList<>(curr));
    }
    else {
      for (int i = idx; i < visited.length; i++) {
        if (visited[i]) {
          continue;
        }
        curr.add(i + 1);
        visited[i] = true;
        helper(ans, curr, visited, k, i + 1);
        curr.remove(curr.size() - 1);
        visited[i] = false;
      }
    }
  }
}
