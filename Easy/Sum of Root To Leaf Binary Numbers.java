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
  public int sumRootToLeaf(TreeNode root) {
    int[] sum = {0};
    helper(root, new StringBuilder(), sum);
    return sum[0];
  }
  
  private void helper(TreeNode root, StringBuilder sb, int[] sum) {
    if (root == null) {
      return;
    }
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      sum[0] += getDecimalValue(sb.toString());
    }
    else {
      helper(root.left, new StringBuilder(sb.toString()), sum);
      helper(root.right, new StringBuilder(sb.toString()), sum);
    }
  }
  
  private int getDecimalValue(String s) {
    int val = 0;
    int mul = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      val += mul * (s.charAt(i) == '1' ? 1 : 0);
      mul *= 2;
    }
    return val;
  }
}
