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
  public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int remainderExpected = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      Integer prev = null;
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        if (removed.val % 2 != remainderExpected) {
          return false;
        }
        if (prev != null) {
          if (remainderExpected == 1 && removed.val <= prev) {
            return false;
          } 
          if (remainderExpected == 0 && removed.val >= prev) {
            return false;
          } 
        }
        prev = removed.val;
        if (removed.left != null) {
          queue.add(removed.left);
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
      }
      remainderExpected = remainderExpected == 1 ? 0 : 1;
    }
    return true;
  }
}
