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
    int[] result = {0};
    helper(root, new StringBuilder(), result);
    return result[0];
  }
  
  private void helper(TreeNode root, StringBuilder sb, int[] result) {
    if (root == null) {
      return;
    }
    sb.append(root.val);
    if (root.left == null && root.right == null) {
      result[0] += getDecimalValue(sb.toString());
      return;
    }
    helper(root.left, new StringBuilder(sb.toString()), result);
    helper(root.right, new StringBuilder(sb.toString()), result);
  }
  
  private int getDecimalValue(String s) {
    int value = 0;
    int powerOfTwo = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      value += ((int) Math.pow(2, powerOfTwo++)) * Character.getNumericValue(s.charAt(i));
    }
    return value;
  }
}
