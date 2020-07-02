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
  public int findBottomLeftValue(TreeNode root) {
    int[] ans = {0, 0};
    helper(root, 1, ans);
    return ans[1];
  }
  
  private void helper(TreeNode root, int currLevel, int[] ans) {
    if (root == null) {
      return;
    }
    if (currLevel > ans[0]) {
      ans[0] = currLevel;
      ans[1] = root.val;
    }
    helper(root.left, currLevel + 1, ans);
    helper(root.right, currLevel + 1, ans);
  }
}
