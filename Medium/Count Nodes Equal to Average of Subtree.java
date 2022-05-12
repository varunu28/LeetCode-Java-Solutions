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
  public int averageOfSubtree(TreeNode root) {
    int[] result = {0};
    helper(root, result);
    return result[0];
  }
  
  private int[] helper(TreeNode root, int[] result) {
    if (root == null) {
      return new int[]{0, 0};
    }
    int[] left = helper(root.left, result);
    int[] right = helper(root.right, result);
    int sum = left[0] + right[0] + root.val;
    int numOfNodes = left[1] + right[1] + 1;
    int average = sum / numOfNodes;
    if (root.val == average) {
      result[0]++;
    }
    return new int[]{sum, numOfNodes};
  }
}
