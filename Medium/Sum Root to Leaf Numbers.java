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
  public int sumNumbers(TreeNode root) {
    int[] sum = {0};
    helper(root, sum, 0);
    return sum[0];
  }
  
  private void helper(TreeNode node, int[] sum, int currVal) {
    if (node == null) {
      return;
    }
    currVal = currVal * 10 + node.val;
    if (node.left == null && node.right == null) {
      sum[0] += currVal;
    }
    else {
      helper(node.left, sum, currVal);
      helper(node.right, sum, currVal);
    }
  }
}
