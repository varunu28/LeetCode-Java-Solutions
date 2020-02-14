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
  int updatedVal = 0;
  public TreeNode convertBST(TreeNode root) {
    helper(root);
    return root;
  }
  
  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.right);
    updatedVal += root.val;
    root.val = updatedVal;
    helper(root.left);
  }
}
