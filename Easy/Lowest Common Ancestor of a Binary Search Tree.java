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
    if (root == null) {
      return root;
    }
    if (root == p || root == q) {
      return root;
    }
    if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    return left == null ? lowestCommonAncestor(root.right, p, q) : left;
  }
}
