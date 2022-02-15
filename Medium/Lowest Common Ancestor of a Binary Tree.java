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
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    TreeNode leftRoot = lowestCommonAncestor(root.left, p, q);
    TreeNode rightRoot = lowestCommonAncestor(root.right, p, q);
    if (leftRoot != null && rightRoot != null) {
      return root;
    }
    return leftRoot != null ? leftRoot : rightRoot;
  }
}
