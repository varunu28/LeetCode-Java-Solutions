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
    helper(root, 0, sum);
    return sum[0];
  }
  
  private void helper(TreeNode root, int currValue, int[] sum) {
    if (root == null) {
      return;
    }
    currValue = currValue * 10 + root.val;
    if (root.left == null && root.right == null) {
      sum[0] += currValue;
      return;
    }
    helper(root.left, currValue, sum);
    helper(root.right, currValue, sum);
  }
}
