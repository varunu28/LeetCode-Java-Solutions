/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    int[] ans = {0};
    Map<Integer, Integer> map = new HashMap<>();
    dfs(root, 0, 0, ans, map);
    return ans[0];
  }
  
  private void dfs(TreeNode root, int depth, int pos, int[] ans, Map<Integer, Integer> map) {
    if (root == null) {
      return;
    }
    map.putIfAbsent(depth, pos);
    ans[0] = Math.max(ans[0], pos - map.get(depth) + 1);
    dfs(root.left, depth + 1, 2 * pos, ans, map);
    dfs(root.right, depth + 1, 2 * pos + 1, ans, map);
  }
}
