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
  int maxVal;
  public int maxPathSum(TreeNode root) {
    maxVal = Integer.MIN_VALUE;
    helper(root);
    return maxVal;
  }
  
  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(helper(root.left), 0);
    int right = Math.max(helper(root.right), 0);
    int sum = root.val + left + right;
    maxVal = Math.max(maxVal, sum);
    return root.val + Math.max(left, right);
  }
}
