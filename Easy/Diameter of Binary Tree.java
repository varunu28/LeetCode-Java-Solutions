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
  public int diameterOfBinaryTree(TreeNode root) {
    int[] diameter = {0};
    dfs(root, diameter);
    return diameter[0];
  }
  
  private int dfs(TreeNode root, int[] diameter) {
    if (root == null) {
      return 0;
    }
    int leftDiameter = dfs(root.left, diameter);
    int rightDiameter = dfs(root.right, diameter);
    diameter[0] = Math.max(leftDiameter + rightDiameter, diameter[0]);
    return Math.max(leftDiameter, rightDiameter) + 1;
  }
}
