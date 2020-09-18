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
  public int goodNodes(TreeNode root) {
    int[] count = {0};
    helper(root, root.val, count);
    return count[0];
  }
  
  private void helper(TreeNode root, int currMax, int[] count) {
    if (root == null) {
      return;
    }
    if (root.val >= currMax) {
      count[0]++;
    }
    helper(root.left, Math.max(currMax, root.val), count);
    helper(root.right, Math.max(currMax, root.val), count);
  }
}
