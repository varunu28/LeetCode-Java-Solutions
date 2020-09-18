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
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int steps = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      // Level iteration
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        // Leaf reached
        if (removed.left == null && removed.right == null) {
          return steps;
        }
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      steps++;
    }
    return steps;
  }
}
