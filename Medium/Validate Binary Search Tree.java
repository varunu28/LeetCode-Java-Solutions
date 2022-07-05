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
  public boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root, (((long) Integer.MAX_VALUE)  + 1), ((long) Integer.MIN_VALUE) - 1);
  }
  
  private boolean isValidBSTHelper(TreeNode node, long max, long min) {
    if (node == null) {
      return true;
    }
    if (node.val >= max || node.val <= min) {
      return false;
    }
    return isValidBSTHelper(node.left, node.val, min) && isValidBSTHelper(node.right, max, node.val);
  }
}
