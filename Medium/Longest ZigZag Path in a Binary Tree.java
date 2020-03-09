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
  int max;
  public int longestZigZag(TreeNode root) {
    if (root == null) {
      return -1;
    }
    max = 0;
    helper(root.right, 1, true);
    helper(root.left, 1, false);
    return max;
  } 
  
  private void helper(TreeNode root, int step, boolean isRight) {
    if (root == null) {
      return;
    }
    max = Math.max(max, step);
    if (isRight) {
      helper(root.left, step + 1, false);
      helper(root.right, 1, true);
    }
    else {
      helper(root.right, step + 1, true);
      helper(root.left, 1, false);
    }
  }
}
