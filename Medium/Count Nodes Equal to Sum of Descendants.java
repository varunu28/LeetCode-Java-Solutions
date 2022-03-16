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
  public int equalToDescendants(TreeNode root) {
    int[] count = {0};
    helper(root, count);
    return count[0];
  }
  
  private int helper(TreeNode root, int[] count) {
    if (root == null) {
      return 0;
    }
    int leftSum = helper(root.left, count);
    int rightSum = helper(root.right, count);
    if (root.val == leftSum + rightSum) {
      count[0]++;
    }
    return root.val + leftSum + rightSum;
  }
}
