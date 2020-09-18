/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public int closestValue(TreeNode root, double target) {
    int[] ans = {0};
    double minDiff = Double.MAX_VALUE;
    helper(root, target, ans, minDiff);
    return ans[0];
  }
  
  private void helper(TreeNode root, double target, int[] ans, double minDiff) {
    if (root == null) {
      return;
    }
    if (Math.abs(root.val - target) < minDiff) {
      minDiff = Math.abs(root.val - target);
      ans[0] = root.val;
    }
    if (root.val < target) {
      helper(root.right, target, ans, minDiff);
    }
    else {
      helper(root.left, target, ans, minDiff);
    }
  }
}
