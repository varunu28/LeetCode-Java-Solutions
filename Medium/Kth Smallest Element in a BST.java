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
  public int kthSmallest(TreeNode root, int k) {
    Integer result = null;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    while (k > 1 && !stack.isEmpty()) {
      TreeNode removed = stack.pop();
      TreeNode rightNode = removed.right;
      while (rightNode != null) {
        stack.push(rightNode);
        rightNode = rightNode.left;
      }
      k--;
    }
    return stack.peek().val;
  }
}
