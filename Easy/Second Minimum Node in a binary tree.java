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
  public int findSecondMinimumValue(TreeNode root) {
    long[] topTwo = {root.val, Long.MAX_VALUE};
    helper(root, topTwo);
    return topTwo[1] == Long.MAX_VALUE ? -1 : (int) topTwo[1];
  }
  
  private void helper(TreeNode root, long[] topTwo) {
    if (root == null) {
      return;
    }
    if (topTwo[0] < root.val && root.val < topTwo[1]) {
      topTwo[1] = root.val;
    } else {
      helper(root.left, topTwo);
      helper(root.right, topTwo);
    }
  }
}
