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
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    }
    else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    }
    else {
      if (root.left == null || root.right == null) {
        TreeNode temp = root.left == null ? root.right : root.left;
        return temp;
      }
      else {
        TreeNode inorderSuccessor = root.right;
        while (inorderSuccessor.left != null) {
          inorderSuccessor = inorderSuccessor.left;
        }
        root.val = inorderSuccessor.val;
        root.right = deleteNode(root.right, inorderSuccessor.val);
      }
    }
    return root;
  }
}
