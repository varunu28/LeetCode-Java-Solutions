/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int findDistance(TreeNode root, int p, int q) {
    if (p == q) {
      return 0;
    }
    int[] result = {-1};
    dfs(root, p, q, result);
    return result[0];
  }
  
  private int dfs(TreeNode root, int p, int q, int[] result) {
    if (root == null) {
      return -1;
    }
    int left = dfs(root.left, p, q, result);
    int right = dfs(root.right, p, q, result);
    if (root.val == p || root.val == q) {
      if (left < 0 && right < 0) {
        return 0;
      }
      result[0] = 1 + (left >= 0 ? left : right);
      return -1;
    }
    if (left >= 0 && right >= 0) {
      result[0] = left + right + 2;
      return -1;
    }
    if (left >= 0) {
      return left + 1;
    }
    if (right >= 0) {
      return right + 1;
    }
    return -1;
  }
}
