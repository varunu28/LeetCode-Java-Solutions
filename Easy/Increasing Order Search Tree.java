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
  public TreeNode increasingBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    TreeNode newHead = null;
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      if (newHead == null) {
        newHead = removed;
      }
      TreeNode rightNode = removed.right;
      while (rightNode != null) {
        stack.push(rightNode);
        rightNode = rightNode.left;
      }
      removed.right = stack.isEmpty() ? null : stack.peek();
      removed.left = null;
    }
    return newHead;
  }
}
