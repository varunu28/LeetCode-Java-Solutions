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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    root = root.left;
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      list.add(removed.val);
      removed = removed.right;
      while (removed != null) {
        stack.push(removed);
        removed = removed.left;
      }
    }
    return list;
  }
}
