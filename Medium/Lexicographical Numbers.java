class Solution {
  public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      dfs(i, n, result);
    }
    return result;
  }
  
  private void dfs(int curr, int n, List<Integer> result) {
    if (curr > n) {
      return;
    }
    result.add(curr);
    for (int i = 0; i < 10; i++) {
      dfs(10 * curr + i, n, result);
    }
  }
}
