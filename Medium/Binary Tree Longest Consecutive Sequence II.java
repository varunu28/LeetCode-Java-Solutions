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
  public int longestConsecutive(TreeNode root) {
    int[] result = {0};
    helper(root, result);
    return result[0];
  }
  
  private int[] helper(TreeNode root, int[] result) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int increment = 1;
    int decrement = 1;
    if (root.left != null) {
      int[] left = helper(root.left, result);
      if (root.val == root.left.val + 1) {
        decrement = left[1] + 1;
      } else if (root.val == root.left.val - 1) {
        increment = left[0] + 1;
      }
    }
    if (root.right != null) {
      int[] right = helper(root.right, result);
      if (root.val == root.right.val + 1) {
        decrement = Math.max(decrement, right[1] + 1);
      } else if (root.val == root.right.val - 1) {
        increment = Math.max(increment, right[0] + 1);
      }
    }
    result[0] = Math.max(result[0], increment + decrement - 1);
    return new int[]{increment, decrement};
  }
}
