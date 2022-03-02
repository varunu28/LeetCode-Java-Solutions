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
  public TreeNode upsideDownBinaryTree(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode rightNode = root.right;
    TreeNode leftNode = root.left;
    root.left = null;
    root.right = null;
    return helper(root, leftNode, rightNode);
  }
  
  private TreeNode helper(TreeNode root, TreeNode leftNode, TreeNode rightNode) {
    if (leftNode == null) {
      return root;
    }
    TreeNode leftNodeLeft = leftNode.left;
    TreeNode leftNodeRight = leftNode.right;
    leftNode.left = rightNode;
    leftNode.right = root;
    return helper(leftNode, leftNodeLeft, leftNodeRight);
  }
}
