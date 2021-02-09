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
  public TreeNode convertBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    addToStack(stack, root);
    int currSum = 0;
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      currSum += removed.val;
      removed.val = currSum;
      addToStack(stack, removed.left);
    }
    return root;
  }
  
  private void addToStack(Stack<TreeNode> stack, TreeNode node) {
    while (node != null) {
      stack.push(node);
      node = node.right;
    }
  }
}
