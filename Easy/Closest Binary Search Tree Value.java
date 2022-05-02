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
  public int closestValue(TreeNode root, double target) {
    double[] result = {Double.MAX_VALUE, -1};
    helper(root, target, result);
    return (int) result[1];
  }   
  
  private void helper(TreeNode root, double target, double[] result) {
    if (root == null) {
      return;
    }
    double diff = Math.abs(root.val - target);
    if (diff <= result[0]) {
      result[0] = diff;
      result[1] = root.val; 
    }
    if (root.val > target) {
      helper(root.left, target, result);
    } else {
      helper(root.right, target, result); 
    }
  }
}
