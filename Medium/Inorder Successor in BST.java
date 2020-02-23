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
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p.right != null) {
      TreeNode node = p.right;
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }
    else {
      TreeNode lastLeft = null;
      while (root != p) {
        if (root.val > p.val) {
          lastLeft = root;
          root = root.left;
        }
        else {
          root = root.right;
        }
      }
      return lastLeft;
    }
  }
}
