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
  public TreeNode bstToGst(TreeNode root) {
    int sum = 0;
    TreeNode node = root;
    Stack<TreeNode> stack = new Stack<>();
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.add(node);
        node = node.right;
      }
      node = stack.pop();
      sum += node.val;
      node.val = sum;
      node = node.left;
    }
    return root;
  }
}
