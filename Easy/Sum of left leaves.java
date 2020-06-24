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
  public int sumOfLeftLeaves(TreeNode root) {
    int[] sum = {0};
    helper(root, null, sum);
    return sum[0];
  } 
  
  private void helper(TreeNode root, TreeNode parent, int[] sum) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (parent != null && parent.left == root) {
        sum[0] += root.val;
      }
    }
    else {
      helper(root.left, root, sum);
      helper(root.right, root, sum);
    }
  }
}
