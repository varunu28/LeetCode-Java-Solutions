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
  int ans;
  public int distributeCoins(TreeNode root) {
    ans = 0;
    dfs(root);
    return ans;
  }
  
  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = dfs(root.left);
    int r = dfs(root.right);
    ans += Math.abs(l) + Math.abs(r);
    return root.val + l + r - 1;
  }
}
