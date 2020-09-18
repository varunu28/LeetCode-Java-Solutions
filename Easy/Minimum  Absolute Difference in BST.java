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
  int minDiff;
  TreeNode prev;
  public int getMinimumDifference(TreeNode root) {
    minDiff = Integer.MAX_VALUE;
    prev = null;
    helper(root);
    return minDiff;
  }
  
  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    if (prev != null) {
      minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
    }
    prev = root;
    helper(root.right);
  }
}
