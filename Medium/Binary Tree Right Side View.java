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
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode rightMost = null;
      while (size-- > 0) {
        TreeNode removed = queue.remove();
        if (rightMost == null) {
          rightMost = removed;
        }
        if (removed.right != null) {
          queue.add(removed.right);
        }
        if (removed.left != null) {
          queue.add(removed.left);
        } 
      }
      list.add(rightMost.val);
    }
    return list;
  }
}
