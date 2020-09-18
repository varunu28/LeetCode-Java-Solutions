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
  public int longestUnivaluePath(TreeNode root) {
    int[] max = {0};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    int leftVal = 0;
    int rightVal = 0;
    if (root.left != null && root.val == root.left.val) {
      leftVal = left + 1;
    }
    if (root.right != null && root.val == root.right.val) {
      rightVal = right + 1;
    }
    max[0] = Math.max(max[0], leftVal + rightVal);
    return Math.max(leftVal, rightVal);
  }
}
