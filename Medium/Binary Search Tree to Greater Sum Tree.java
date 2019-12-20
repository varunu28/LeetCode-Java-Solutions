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
  public TreeNode bstToGst(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode curr = root;
    Stack<TreeNode> stack = new Stack<>();
    int sum = 0;
    pushRight(stack, curr);
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      sum += removed.val;
      removed.val = sum;
      TreeNode leftNode = removed.left;
      pushRight(stack, leftNode);
    }
    return root;
  }
  
  private void pushRight(Stack<TreeNode> stack, TreeNode curr) {
    while (curr != null) {
      stack.push(curr);
      curr = curr.right;
    }
  }
}
