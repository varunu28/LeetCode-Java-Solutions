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
  public TreeNode findNeartestRightNode(TreeNode root, TreeNode u) {
    if (root == null) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean found = false;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        if (found) {
          return removed;
        }
        if (removed == u) {
          found = true;
        }
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      if (found) {
        break;
      }
    }
    return null;
  }
}
