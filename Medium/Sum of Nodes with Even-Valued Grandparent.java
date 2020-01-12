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
  public int sumEvenGrandparent(TreeNode root) {
    int[] ans = {0};
    helper(root, -1, -1, ans);
    return ans[0];
  }
  
  private void helper(TreeNode root, int parent, int grandparent, int[] ans) {
    if (root == null) {
      return;
    }
    if (grandparent > 0 && grandparent % 2 == 0) {
      ans[0] += root.val;
    }
    grandparent = parent;
    parent = root.val;
    helper(root.left, parent, grandparent, ans);
    helper(root.right, parent, grandparent, ans);
  }
}
