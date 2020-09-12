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
  public int maxSumBST(TreeNode root) {
    int[] ans = {0};
    helper(root, ans);
    return ans[0];
  }
  
  private int[] helper(TreeNode root, int[] ans) {
    if (root == null) {
      // new int[]{min, max, sum}
      return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    }
    int[] left = helper(root.left, ans);
    int[] right = helper(root.right, ans);
    if (!(left != null && right != null && root.val > left[1] && root.val < right[0])) {
      return null;
    }
    int sum = root.val + left[2] + right[2];
    ans[0] = Math.max(ans[0], sum);
    int min = Math.min(root.val, left[0]);
    int max = Math.max(root.val, right[1]);
    return new int[]{min, max, sum};
  }
}
