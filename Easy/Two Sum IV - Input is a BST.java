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
  public boolean findTarget(TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    Stack<TreeNode> stack = new Stack<>();
    Set<Integer> set = new HashSet<>();
    while (root != null) {
      if (set.contains(k - root.val)) {
        return true;
      }
      stack.push(root);
      set.add(root.val);
      root = root.left;
    }
    while (!stack.isEmpty()) {
      TreeNode removed = stack.pop();
      TreeNode rightNode = removed.right;
      while (rightNode != null) {
        if (set.contains(k - rightNode.val)) {
          return true;
        }
        stack.push(rightNode);
        set.add(rightNode.val);
        rightNode = rightNode.left;
      }
    }
    return false;
  }
}
