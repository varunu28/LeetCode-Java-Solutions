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
  Integer minimum;
  long secondMinimum;
  public int findSecondMinimumValue(TreeNode root) {
    minimum = root.val;
    secondMinimum = Long.MAX_VALUE;
    helper(root);
    return secondMinimum == Long.MAX_VALUE ? -1 : (int) secondMinimum;
  }
  
  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    if (minimum < root.val && root.val < secondMinimum) {
      secondMinimum = root.val;
    }
    else if (root.val == minimum) {
      helper(root.left);
      helper(root.right);
    }
  }
}
