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
  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] count = {0};
    helper(root, count, root.val);
    return count[0];
  }
  
  private boolean helper(TreeNode root, int[] count, int val) {
    if (root == null) {
      return true;
    }
    if (!helper(root.left, count, root.val) | !helper(root.right, count, root.val)) {
      return false;
    }
    count[0]++;
    return root.val == val;
  }
}
