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
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    if (root1 == null || root2 == null) {
      return false;
    }
    Set<Integer> set = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root2);
    while (!queue.isEmpty()) {
      TreeNode removed = queue.remove();
      set.add(removed.val);
      if (removed.left != null) {
        queue.add(removed.left);
      }
      if (removed.right != null) {
        queue.add(removed.right);
      }
    }
    queue = new LinkedList<>();
    queue.add(root1);
    while (!queue.isEmpty()) {
      TreeNode removed = queue.remove();
      if (set.contains(target - removed.val)) {
        return true;
      }
      if (removed.left != null) {
        queue.add(removed.left);
      }
      if (removed.right != null) {
        queue.add(removed.right);
      }
    }
    return false;
  }
}
