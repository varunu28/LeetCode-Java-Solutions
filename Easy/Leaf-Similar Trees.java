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
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    return getLeaves(root1).equals(getLeaves(root2));
  }   
  
  private List<Integer> getLeaves(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> leaves = new ArrayList<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      if (removed.left == null && removed.right == null) {
        leaves.add(removed.val);
      } else {
        TreeNode rightNode = removed.right;
        while (rightNode != null) {
          stack.push(rightNode);
          rightNode = rightNode.left;
        }
      }
    }
    return leaves;
  }
}
