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
  public boolean isValidBST(TreeNode root) {
    long min = (long) Integer.MIN_VALUE;
    long max = (long) Integer.MAX_VALUE;
    return helper(root, min - 1, max + 1);
  }
  
  private boolean helper(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    if (root.val <= min || root.val >= max) {
      return false;
    }
    return helper(root.left, min, (long) root.val) && helper(root.right, (long) root.val, max);
  }
}
