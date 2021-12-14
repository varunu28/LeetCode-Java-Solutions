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
  public int rangeSumBST(TreeNode root, int low, int high) {
    int[] rangeSum = {0};
    helper(root, low, high, rangeSum);
    return rangeSum[0];
  }
  
  private void helper(TreeNode root, int low, int high, int[] rangeSum) {
    if (root == null) {
      return;
    }
    if (root.val >= low && root.val <= high) {
      rangeSum[0] += root.val;
    }
    if (root.val >= low) {
      helper(root.left, low, high, rangeSum);
    }
    if (root.val <= high) {
      helper(root.right, low, high, rangeSum);
    }
  }
}
