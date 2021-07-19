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
    if (root == p || root == q || 
        (p.val > root.val && q.val < root.val) || 
        (p.val < root.val && q.val > root.val)) {
      return root;
    }
    return ((root.val > p.val && root.val > q.val) ? 
            lowestCommonAncestor(root.left, p, q) : 
            lowestCommonAncestor(root.right, p, q));
  }
}
