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
  TreeNode curr;
  public TreeNode increasingBST(TreeNode root) {
    TreeNode ans = new TreeNode(-1);
    curr = ans;
    inorder(root);
    return ans.right;
  }
  
  private void inorder(TreeNode node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    node.left = null;
    curr.right = node;
    curr = node;
    inorder(node.right);
  }
}
