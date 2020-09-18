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
  double maxAvg;
  public double maximumAverageSubtree(TreeNode root) {
    maxAvg = 0.0;
    helper(root);
    return maxAvg;
  }
  
  private int[] helper(TreeNode root) {
    int[] data = new int[2];
    if (root == null) {
      return data;
    }
    int[] dataLeft = helper(root.left);
    int[] dataRight = helper(root.right);
    data[0] += root.val + dataLeft[0] + dataRight[0];
    data[1] += 1 + dataLeft[1] + dataRight[1];
    double avg = ((double) data[0]) / data[1];
    maxAvg = Math.max(maxAvg, avg);
    return data;
  }
}
