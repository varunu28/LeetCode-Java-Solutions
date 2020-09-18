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
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper(root.left, root.right);
  }
  
  private boolean helper(TreeNode r, TreeNode l) {
    if (r == null && l == null) {
      return true;
    }
    if (r == null || l == null) {
      return false;
    }
    if (r.val != l.val) {
      return false;
    }
    return helper(l.left, r.right) && helper(l.right, r.left);
  }
}
