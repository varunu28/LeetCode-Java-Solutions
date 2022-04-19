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
  public void recoverTree(TreeNode root) {
    TreeNode nodeOne = null;
    TreeNode nodeTwo = null;
    TreeNode prevNode = null;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      if (!stack.isEmpty()) {
        root = stack.pop();
        if (nodeOne == null && prevNode != null && prevNode.val > root.val) {
          nodeOne = prevNode;
        }
        if (nodeOne != null && prevNode.val > root.val) {
          nodeTwo = root;
        }
        prevNode = root;
        root = root.right;
      }
    }
    int tempValue = nodeOne.val;
    nodeOne.val = nodeTwo.val;
    nodeTwo.val = tempValue;
  }
}
