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
      TreeNode rightNode = p.right;
      while (rightNode != null && rightNode.left != null) {
        rightNode = rightNode.left;
      }
      return rightNode;
    }
    TreeNode prev = null;
    while (root != p) {
      if (root.val > p.val) {
        prev = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return prev;
  }
}
